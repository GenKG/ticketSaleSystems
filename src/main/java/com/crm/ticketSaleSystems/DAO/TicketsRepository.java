package com.crm.ticketSaleSystems.DAO;

import com.crm.ticketSaleSystems.model.TicketsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketsRepository extends JpaRepository<TicketsEntity, Long> {
}
