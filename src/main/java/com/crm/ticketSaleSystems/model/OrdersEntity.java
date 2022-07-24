package com.crm.ticketSaleSystems.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "orders", schema = "public", catalog = "ticketsale")
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class OrdersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Basic
    @Column(name = "client_name")
    private String clientName;
    @Basic
    @Column(name = "client_address")
    private String clientAddress;
    @Basic
    @Column(name = "client_phone")
    private String clientPhone;
    @Basic
    @Column(name = "tickets_count")
    private Integer ticketsCount;
    @Basic
    @Column(name = "sum")
    private Integer sum;
    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<TicketsEntity> tickets;
}
