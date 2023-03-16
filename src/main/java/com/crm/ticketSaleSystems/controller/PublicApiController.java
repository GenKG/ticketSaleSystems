package com.crm.ticketSaleSystems.controller;

import com.crm.ticketSaleSystems.model.OrdersDTO;
import com.crm.ticketSaleSystems.service.BankApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PublicApiController {
    private final BankApiService bankApiService;

    @Autowired
    public PublicApiController(BankApiService bankApiService) {
        this.bankApiService = bankApiService;
    }

    @PostMapping("/orders")
    private ResponseEntity<String> requestOrder(@RequestBody OrdersDTO order) {
        bankApiService.saveOrder(order);
        return ResponseEntity.ok().build();
    }
}
