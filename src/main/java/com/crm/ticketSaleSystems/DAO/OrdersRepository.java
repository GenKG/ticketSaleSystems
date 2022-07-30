package com.crm.ticketSaleSystems.DAO;

import com.crm.ticketSaleSystems.model.OrdersEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersRepository extends JpaRepository<OrdersEntity, Long> {
    @EntityGraph(
            type = EntityGraph.EntityGraphType.FETCH,
            attributePaths = "tickets"
    )
    @Override
    List<OrdersEntity> findAll();

}
