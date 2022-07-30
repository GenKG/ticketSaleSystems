package com.crm.ticketSaleSystems.DAO;

import com.crm.ticketSaleSystems.model.EventsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventsRepository extends JpaRepository<EventsEntity,Long> {
}
