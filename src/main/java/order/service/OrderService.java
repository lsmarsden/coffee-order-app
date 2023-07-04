package order.service;

import decorator.Coffee;
import decorator.CoffeeBuilder;
import decorator.SimpleCoffee;
import lombok.RequiredArgsConstructor;
import order.model.Order;
import order.repository.IOrderRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@RequiredArgsConstructor
public class OrderService implements IOrderService {

    private final IOrderRepository orderRepository;

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

        return orderRepository.save(order);
    }
}
