package com.crm.ticketSaleSystems.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "orders", schema = "public", catalog = "ticketsale")
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
    @Basic
    @Column(name = "ticket_id")
    private int ticketId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    public Integer getTicketsCount() {
        return ticketsCount;
    }

    public void setTicketsCount(Integer ticketsCount) {
        this.ticketsCount = ticketsCount;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdersEntity that = (OrdersEntity) o;
        return Objects.equals(id, that.id) && ticketId == that.ticketId && Objects.equals(clientName, that.clientName) && Objects.equals(clientAddress, that.clientAddress) && Objects.equals(clientPhone, that.clientPhone) && Objects.equals(ticketsCount, that.ticketsCount) && Objects.equals(sum, that.sum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clientName, clientAddress, clientPhone, ticketsCount, sum, ticketId);
    }
}
