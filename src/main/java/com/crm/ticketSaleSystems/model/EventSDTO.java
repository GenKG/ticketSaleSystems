package com.crm.ticketSaleSystems.model;

import lombok.*;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Setter
@Getter
@ToString
public class EventSDTO {
    private String eventName;
    private Instant eventDate;
    private String venue;
    private String venueAddress;
}
