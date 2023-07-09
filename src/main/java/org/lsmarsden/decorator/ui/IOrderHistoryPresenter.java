package org.lsmarsden.decorator.ui;

import org.lsmarsden.order.model.Order;

import java.util.List;

public interface IOrderHistoryPresenter {

    List<Order> getOrderHistory();
}
