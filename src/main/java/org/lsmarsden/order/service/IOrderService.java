package org.lsmarsden.order.service;

import org.lsmarsden.order.model.Order;

import java.util.List;

public interface IOrderService {
    Order createOrder(int milkQuantity, int sugarQuantity);

    List<Order> getOrderHistory();
}
