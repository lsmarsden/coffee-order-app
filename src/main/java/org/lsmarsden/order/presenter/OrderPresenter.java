package org.lsmarsden.order.presenter;

import org.lsmarsden.decorator.ui.IOrderView;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.lsmarsden.order.model.Order;
import org.lsmarsden.order.service.IOrderService;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@RequiredArgsConstructor
public class OrderPresenter implements IOrderPresenter {

    private final IOrderService orderService;
    @Setter(onMethod_ = @Override)
    private IOrderView orderView;

    @Override
    public void submitOrder(int milkQuantity, int sugarQuantity) {

        Order order = orderService.createOrder(milkQuantity, sugarQuantity);
        orderView.displayOrderDetails(order);
    }
}
