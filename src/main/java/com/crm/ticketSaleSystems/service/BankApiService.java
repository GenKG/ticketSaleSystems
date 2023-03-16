package com.crm.ticketSaleSystems.service;

import com.crm.ticketSaleSystems.DAO.OrdersRepository;
import com.crm.ticketSaleSystems.model.OrdersDTO;
import com.crm.ticketSaleSystems.model.OrdersEntity;
import com.crm.ticketSaleSystems.util.DtoMappingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankApiService {
    private final OrdersRepository ordersRepository;
    @Autowired
    public BankApiService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public void saveOrder(OrdersDTO order){
        OrdersEntity savedOrder = ordersRepository.save(DtoMappingUtil.orderMapping(order));
    }
}
