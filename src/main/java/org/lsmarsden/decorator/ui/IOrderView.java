package org.lsmarsden.decorator.ui;

import org.lsmarsden.order.model.Order;

public interface IOrderView {

    void show();

    void displayOrderDetails(Order order);
}
