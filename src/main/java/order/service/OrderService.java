package order.service;

import decorator.Coffee;
import decorator.CoffeeBuilder;
import decorator.SimpleCoffee;
import lombok.RequiredArgsConstructor;
import order.model.Order;
import order.repository.IOrderRepository;
import user.model.User;
import user.service.IUserService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
public class OrderService implements IOrderService {

    private final IOrderRepository orderRepository;

    private final IUserService userService;

    @Override
    public Order createOrder(int milkQuantity, int sugarQuantity) {

        Coffee coffee = CoffeeBuilder.builder(new SimpleCoffee())
                .milk(milkQuantity)
                .sugar(sugarQuantity)
                .build();

        Order order = new Order();
        order.setCost(BigDecimal.valueOf(coffee.getCost()));
        order.setOrderDate(LocalDateTime.now());
        order.setDescription(coffee.getDescription());
        order.setCreatedBy(userService.getCurrentUser());

        return orderRepository.save(order);
    }

    @Override
    public List<Order> getOrderHistory() {

        User currentUser = userService.getCurrentUser();

        return orderRepository.getOrderHistory(currentUser);
    }
}
