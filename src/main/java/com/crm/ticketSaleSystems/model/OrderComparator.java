package com.crm.ticketSaleSystems.model;

import com.crm.ticketSaleSystems.model.paging.Direction;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class OrderComparator {
    static Map<Key, Comparator<OrdersEntity>> map = new HashMap<>();

    static {
        map.put(new Key("orderId",Direction.asc),Comparator.comparing(OrdersEntity::getOrderId));
        map.put(new Key("orderId",Direction.desc),Comparator.comparing(OrdersEntity::getOrderId)
                .reversed());

        map.put(new Key("clientName", Direction.asc), Comparator.comparing(OrdersEntity::getClientName));
        map.put(new Key("clientName", Direction.desc), Comparator.comparing(OrdersEntity::getClientName)
                .reversed());

        map.put(new Key("clientAddress", Direction.asc), Comparator.comparing(OrdersEntity::getClientAddress));
        map.put(new Key("clientAddress", Direction.desc), Comparator.comparing(OrdersEntity::getClientAddress)
                .reversed());

        map.put(new Key("clientPhone", Direction.asc), Comparator.comparing(OrdersEntity::getClientPhone));
        map.put(new Key("clientPhone", Direction.desc), Comparator.comparing(OrdersEntity::getClientPhone)
                .reversed());

        map.put(new Key("sum", Direction.asc), Comparator.comparing(OrdersEntity::getSum));
        map.put(new Key("sum", Direction.desc), Comparator.comparing(OrdersEntity::getSum)
                .reversed());

        map.put(new Key("ticketsCount", Direction.asc), Comparator.comparing(OrdersEntity::getTicketsCount));
        map.put(new Key("ticketsCount", Direction.desc), Comparator.comparing(OrdersEntity::getTicketsCount)
                .reversed());
    }

    private OrderComparator() {
    }

    public static Comparator<OrdersEntity> getComparator(String name, Direction dir) {
        return map.get(new Key(name, dir));
    }

    @EqualsAndHashCode
    @AllArgsConstructor
    @Getter
    static class Key {
        String name;
        Direction dir;
    }
}
