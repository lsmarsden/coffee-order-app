package order.repository;

import order.model.Order;

public interface IOrderRepository {

    Order save(Order order);
}
