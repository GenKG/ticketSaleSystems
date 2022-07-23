package com.crm.ticketSaleSystems.model;

import javax.persistence.*;

@Entity
@Table(name = "orders", schema = "public", catalog = "ticketsale")
public class OrdersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

        if (id != that.id) return false;
        if (ticketId != that.ticketId) return false;
        if (clientName != null ? !clientName.equals(that.clientName) : that.clientName != null) return false;
        if (clientAddress != null ? !clientAddress.equals(that.clientAddress) : that.clientAddress != null)
            return false;
        if (clientPhone != null ? !clientPhone.equals(that.clientPhone) : that.clientPhone != null) return false;
        if (ticketsCount != null ? !ticketsCount.equals(that.ticketsCount) : that.ticketsCount != null) return false;
        if (sum != null ? !sum.equals(that.sum) : that.sum != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (clientName != null ? clientName.hashCode() : 0);
        result = 31 * result + (clientAddress != null ? clientAddress.hashCode() : 0);
        result = 31 * result + (clientPhone != null ? clientPhone.hashCode() : 0);
        result = 31 * result + (ticketsCount != null ? ticketsCount.hashCode() : 0);
        result = 31 * result + (sum != null ? sum.hashCode() : 0);
        result = 31 * result + ticketId;
        return result;
    }
}
