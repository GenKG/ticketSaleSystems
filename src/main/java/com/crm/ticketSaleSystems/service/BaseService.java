package com.crm.ticketSaleSystems.service;

import com.crm.ticketSaleSystems.DAO.OrderRepository;
import com.crm.ticketSaleSystems.model.OrdersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseService {
    private final OrderRepository orderRepository;
    @Autowired
    public BaseService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrdersEntity> getAllOrders(){
        return orderRepository.findAll();
    }

}
