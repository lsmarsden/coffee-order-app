package order.service;

import order.model.Order;

public interface IOrderService {
    Order createOrder(int milkQuantity, int sugarQuantity);
}
