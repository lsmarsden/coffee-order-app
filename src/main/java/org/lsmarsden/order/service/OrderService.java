package org.lsmarsden.order.service;

import org.lsmarsden.decorator.Coffee;
import org.lsmarsden.decorator.CoffeeBuilder;
import org.lsmarsden.decorator.SimpleCoffee;
import lombok.RequiredArgsConstructor;
import org.lsmarsden.order.model.Order;
import org.lsmarsden.order.repository.IOrderRepository;
import org.springframework.stereotype.Service;
import org.lsmarsden.user.model.User;
import org.lsmarsden.user.service.IUserService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
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

        return orderRepository.findByCreatedBy(currentUser);
    }
}
