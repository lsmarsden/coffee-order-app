package org.lsmarsden.rest.order;

import lombok.RequiredArgsConstructor;
import org.lsmarsden.order.model.Order;
import org.lsmarsden.order.service.IOrderService;
import org.lsmarsden.rest.order.model.OrderRequest;
import org.lsmarsden.rest.order.model.OrderResponse;
import org.lsmarsden.security.ApiKeyAuthentication;
import org.lsmarsden.security.IAPIKeyService;
import org.lsmarsden.security.IAuthenticationFacade;
import org.lsmarsden.user.model.User;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderAPIService implements IOrderAPIService {

    private final IOrderService orderService;

    private final IAPIKeyService apiKeyService;

    private final IAuthenticationFacade authenticationFacade;

    @Override
    public OrderResponse createOrder(OrderRequest orderRequest) {

        // if you make it here, you're authenticated
        // so get the api key authentication and get the user of that key
        // then pass that user through
        ApiKeyAuthentication authentication = authenticationFacade.getApiKeyAuthentication();
        User user = apiKeyService.getUserByApiKey(authentication.getPrincipal());

        Order order = orderService.createOrder(user, orderRequest.milkQuantity(), orderRequest.sugarQuantity());
        return convertToResponse(order);
    }

    private OrderResponse convertToResponse(Order order) {
        return new OrderResponse(order.getId(), order.getId());
    }
}
