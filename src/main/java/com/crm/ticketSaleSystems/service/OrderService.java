package com.crm.ticketSaleSystems.service;

import com.crm.ticketSaleSystems.model.OrderComparator;
import com.crm.ticketSaleSystems.model.OrdersEntity;
import com.crm.ticketSaleSystems.model.paging.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Service
public class OrderService {
    private static final Comparator<OrdersEntity> EMPTY_COMPARATOR = (e1, e2) -> 0;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

    public PageArray getOrdersArray(PagingRequest pagingRequest) {
        pagingRequest.setColumns(Stream.of("clientName", "clientAddress", "clientPhone", "ticketsCount", "ticketsSum")
                .map(Column::new)
                .collect(Collectors.toList()));
        Page<OrdersEntity> orderPage = getOrders(pagingRequest);

        PageArray pageArray = new PageArray();
        pageArray.setRecordsFiltered(orderPage.getRecordsFiltered());
        pageArray.setRecordsTotal(orderPage.getRecordsTotal());
        pageArray.setDraw(orderPage.getDraw());
        pageArray.setData(orderPage.getData()
                .stream()
                .map(this::toStringList)
                .collect(Collectors.toList()));
        return pageArray;
    }

    private List<String> toStringList(OrdersEntity order) {
        return Arrays.asList(order.getClientName(), order.getClientAddress(), order.getClientPhone(), order.getTicketsCount().toString(), order.getSum().toString());
    }

    public Page<OrdersEntity> getOrders(PagingRequest pagingRequest) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            List<OrdersEntity> orders = objectMapper.readValue(getClass().getClassLoader()
                            .getResourceAsStream("orders.json"),
                    new TypeReference<List<OrdersEntity>>() {
                    });

            return getPage(orders, pagingRequest);

        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }

        return new Page<>();
    }

    private Page<OrdersEntity> getPage(List<OrdersEntity> orders, PagingRequest pagingRequest) {
        List<OrdersEntity> filtered = orders.stream()
                .sorted(sortOrders(pagingRequest))
                .filter(filterEmployees(pagingRequest))
                .skip(pagingRequest.getStart())
                .limit(pagingRequest.getLength())
                .collect(Collectors.toList());

        long count = orders.stream()
                .filter(filterEmployees(pagingRequest))
                .count();

        Page<OrdersEntity> page = new Page<>(filtered);
        page.setRecordsFiltered((int) count);
        page.setRecordsTotal((int) count);
        page.setDraw(pagingRequest.getDraw());

        return page;
    }

    private Predicate<OrdersEntity> filterEmployees(PagingRequest pagingRequest) {
        if (pagingRequest.getSearch() == null || StringUtils.isEmpty(pagingRequest.getSearch()
                .getValue())) {
            return order -> true;
        }

        String value = pagingRequest.getSearch()
                .getValue();

        return order -> order.getClientName()
                .toLowerCase()
                .contains(value)
                || order.getClientAddress()
                .toLowerCase()
                .contains(value)
                || order.getClientPhone()
                .toLowerCase()
                .contains(value);
    }

    private Comparator<OrdersEntity> sortOrders(PagingRequest pagingRequest) {
        if (pagingRequest.getOrder() == null) {
            return EMPTY_COMPARATOR;
        }

        try {
            Order order = pagingRequest.getOrder()
                    .get(0);

            int columnIndex = order.getColumn();
            Column column = pagingRequest.getColumns()
                    .get(columnIndex);

            Comparator<OrdersEntity> comparator = OrderComparator.getComparator(column.getData(), order.getDir());
            if (comparator == null) {
                return EMPTY_COMPARATOR;
            }

            return comparator;

        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return EMPTY_COMPARATOR;
    }
}
