package order.repository;

import order.model.Order;
import user.model.User;

import java.util.List;

public interface IOrderRepository {

    Order save(Order order);

    List<Order> getOrderHistory(User user);
}
