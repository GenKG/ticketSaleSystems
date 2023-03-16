package com.crm.ticketSaleSystems.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@ToString
public class TicketsDTO {
    private Long ticketSum;
    private EventSDTO event;
}
