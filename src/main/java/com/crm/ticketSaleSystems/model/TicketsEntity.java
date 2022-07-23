package com.crm.ticketSaleSystems.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tickets", schema = "public", catalog = "ticketsale")
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        return Objects.equals(id, that.id) && eventId == that.eventId && Objects.equals(number, that.number) && Objects.equals(sum, that.sum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, sum, eventId);
    }
}
