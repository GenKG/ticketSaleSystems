package com.crm.ticketSaleSystems.model;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@ToString
public class OrdersDTO {
    private String clientName;
    private String clientAddress;
    private String clientPhone;
    private Integer ticketsCount;
    private Integer sum;
    private List<TicketsDTO> ticketsList;
}
