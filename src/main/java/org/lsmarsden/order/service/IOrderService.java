package org.lsmarsden.order.service;

import org.lsmarsden.order.model.Order;
import org.lsmarsden.user.model.User;

import java.util.List;

public interface IOrderService {
    Order createOrder(int milkQuantity, int sugarQuantity);

    Order createOrder(User createdBy, int milkQuantity, int sugarQuantity);

    List<Order> getOrderHistory();
}
