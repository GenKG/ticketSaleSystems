package com.crm.ticketSaleSystems.model;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tickets", schema = "public", catalog = "ticketsale")
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class TicketsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Basic
    @Column(name = "number")
    private Long number;
    @Basic
    @Column(name = "sum")
    private Long sum;
    @Basic
    @Column(name = "event_id")
    private int eventId;
}
