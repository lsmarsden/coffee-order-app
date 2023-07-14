package org.lsmarsden.rest.order;

import lombok.RequiredArgsConstructor;
import org.lsmarsden.order.model.Order;
import org.lsmarsden.order.service.IOrderService;
import org.lsmarsden.rest.order.model.OrderRequest;
import org.lsmarsden.rest.order.model.OrderResponse;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderAPIService implements IOrderAPIService {

    private final IOrderService orderService;

    @Override
    public OrderResponse createOrder(OrderRequest orderRequest) {

        Order order = orderService.createOrder(orderRequest.milkQuantity(), orderRequest.sugarQuantity());
        return convertToResponse(order);
    }

    private OrderResponse convertToResponse(Order order) {
        return new OrderResponse(order.getId(), order.getId());
    }
}
