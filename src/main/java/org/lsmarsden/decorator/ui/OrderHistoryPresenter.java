package org.lsmarsden.decorator.ui;

import lombok.RequiredArgsConstructor;
import org.lsmarsden.order.model.Order;
import org.lsmarsden.order.service.IOrderService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderHistoryPresenter implements IOrderHistoryPresenter {

    private final IOrderService orderService;

    @Override
    public List<Order> getOrderHistory() {
        return orderService.getOrderHistory();
    }
}
