package com.crm.ticketSaleSystems.controller;

import com.crm.ticketSaleSystems.model.OrdersEntity;
import com.crm.ticketSaleSystems.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BaseController {
    private final BaseService baseService;

    @Autowired
    public BaseController(BaseService baseService) {
        this.baseService = baseService;
    }
    @GetMapping(path = "/getOrders")
    public List<OrdersEntity> getAllOrder() {
        return baseService.getAllOrders();
    }
}
