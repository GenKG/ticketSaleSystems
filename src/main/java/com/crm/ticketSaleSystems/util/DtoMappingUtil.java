package com.crm.ticketSaleSystems.util;

import com.crm.ticketSaleSystems.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DtoMappingUtil {
    private static final Random rnd = new Random();
    private static final int min = 1;
    private static final int max = 1000000000;
    private static final int diff = max - min;
    private DtoMappingUtil() {
    }
    public static OrdersEntity orderMapping(OrdersDTO ordersDTO){
        OrdersEntity dbOrder = new OrdersEntity();

        dbOrder.setOrderId(rnd.nextInt(diff + 1));
        dbOrder.setClientName(ordersDTO.getClientName());
        dbOrder.setClientAddress(ordersDTO.getClientAddress());
        dbOrder.setClientPhone(ordersDTO.getClientPhone());
        dbOrder.setSum(ordersDTO.getSum());
        dbOrder.setTicketsCount(ordersDTO.getTicketsCount());
        List<TicketsDTO> ticketsList = ordersDTO.getTicketsList();
        List<TicketsEntity> dbTicketsList = new ArrayList<>();
        ticketsList.forEach(ticketDTO ->{
            TicketsEntity ticket = new TicketsEntity();
            ticket.setNumber((long) rnd.nextInt(diff + 1));
            ticket.setSum(ticketDTO.getTicketSum());

            EventSDTO event = ticketDTO.getEvent();
            EventsEntity eventDb = new EventsEntity();
            eventDb.setEventName(event.getEventName());
            eventDb.setEventDate(event.getEventDate());
            eventDb.setVenue(event.getVenue());
            eventDb.setVenueAddress(event.getVenueAddress());

            ticket.setEvent(eventDb);
            dbTicketsList.add(ticket);
        });
        dbOrder.setTickets(dbTicketsList);
        return dbOrder;
    }
}
