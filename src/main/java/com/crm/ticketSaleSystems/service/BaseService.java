package com.crm.ticketSaleSystems.service;

import com.crm.ticketSaleSystems.DAO.EventsRepository;
import com.crm.ticketSaleSystems.DAO.OrdersRepository;
import com.crm.ticketSaleSystems.DAO.TicketsRepository;
import com.crm.ticketSaleSystems.model.EventsEntity;
import com.crm.ticketSaleSystems.model.OrdersEntity;
import com.crm.ticketSaleSystems.model.TicketsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseService {
    private final OrdersRepository ordersRepository;
    private final TicketsRepository ticketsRepository;

    private final EventsRepository eventsRepository;

    @Autowired
    public BaseService(OrdersRepository ordersRepository, TicketsRepository ticketsRepository, EventsRepository eventsRepository) {
        this.ordersRepository = ordersRepository;
        this.ticketsRepository = ticketsRepository;
        this.eventsRepository = eventsRepository;
    }

    public List<OrdersEntity> getAllOrders() {
        return ordersRepository.findAll();
    }

    public List<TicketsEntity> getAllTickets() {
        return ticketsRepository.findAll();
    }
    public List<EventsEntity> getAllEvents(){
        return eventsRepository.findAll();
    }

}
