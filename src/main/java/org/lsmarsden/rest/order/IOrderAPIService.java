package org.lsmarsden.rest.order;

import org.lsmarsden.rest.order.model.OrderRequest;
import org.lsmarsden.rest.order.model.OrderResponse;

public interface IOrderAPIService {

    OrderResponse createOrder(OrderRequest orderRequest);
}
