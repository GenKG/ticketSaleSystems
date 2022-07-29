package com.crm.ticketSaleSystems.model;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "events", schema = "public", catalog = "ticketsale")
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class EventsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Basic
    @Column(name = "event_name")
    private String eventName;
    @Basic
    @Column(name = "event_date")
    private Instant eventDate;
    @Basic
    @Column(name = "venue")
    private String venue;
    @Basic
    @Column(name = "venue_address")
    private String venueAddress;
}

