package org.lsmarsden.order.repository;

import org.lsmarsden.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.lsmarsden.user.model.User;

import java.util.List;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Long> {


    List<Order> findByCreatedBy(User user);
}
