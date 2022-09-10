package com.crm.ticketSaleSystems.controller;

import com.crm.ticketSaleSystems.model.OrdersEntity;
import com.crm.ticketSaleSystems.model.paging.Page;
import com.crm.ticketSaleSystems.model.paging.PageArray;
import com.crm.ticketSaleSystems.model.paging.PagingRequest;
import com.crm.ticketSaleSystems.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ordersTable")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Page<OrdersEntity> list(@RequestBody PagingRequest pagingRequest) {
        return orderService.getOrders(pagingRequest);
    }

   /* @PostMapping("/array")
    public PageArray array(@RequestBody PagingRequest pagingRequest) {
        return orderService.getOrdersArray(pagingRequest);
    }*/
}
