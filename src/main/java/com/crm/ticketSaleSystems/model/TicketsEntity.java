package com.crm.ticketSaleSystems.model;

import javax.persistence.*;

@Entity
@Table(name = "tickets", schema = "public", catalog = "ticketsale")
public class TicketsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "number")
    private Long number;
    @Basic
    @Column(name = "sum")
    private Long sum;
    @Basic
    @Column(name = "event_id")
    private int eventId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Long getSum() {
        return sum;
    }

    public void setSum(Long sum) {
        this.sum = sum;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TicketsEntity that = (TicketsEntity) o;

        if (id != that.id) return false;
        if (eventId != that.eventId) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (sum != null ? !sum.equals(that.sum) : that.sum != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (sum != null ? sum.hashCode() : 0);
        result = 31 * result + eventId;
        return result;
    }
}
