package com.crm.ticketSaleSystems.DAO;

import com.crm.ticketSaleSystems.model.OrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrdersEntity, Long> {
}
