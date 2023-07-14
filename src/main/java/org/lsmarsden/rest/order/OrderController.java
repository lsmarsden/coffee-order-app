package org.lsmarsden.rest.order;

import lombok.RequiredArgsConstructor;
import org.lsmarsden.rest.order.model.OrderRequest;
import org.lsmarsden.rest.order.model.OrderResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/coffee")
@RequiredArgsConstructor
public class OrderController {
    private final IOrderAPIService orderAPIService;


    @PostMapping("/order")
    public ResponseEntity<OrderResponse> placeOrder(@RequestBody OrderRequest orderRequest) {

        OrderResponse orderResponse = orderAPIService.createOrder(orderRequest);
        return ResponseEntity.ok(orderResponse);
    }
}
