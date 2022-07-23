package com.crm.ticketSaleSystems.model;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "events", schema = "public", catalog = "ticketsale")
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Instant getEventDate() {
        return eventDate;
    }

    public void setEventDate(Instant eventDate) {
        this.eventDate = eventDate;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getVenueAddress() {
        return venueAddress;
    }

    public void setVenueAddress(String venueAddress) {
        this.venueAddress = venueAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventsEntity that = (EventsEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(eventName, that.eventName) && Objects.equals(eventDate, that.eventDate) && Objects.equals(venue, that.venue) && Objects.equals(venueAddress, that.venueAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, eventName, eventDate, venue, venueAddress);
    }
}
