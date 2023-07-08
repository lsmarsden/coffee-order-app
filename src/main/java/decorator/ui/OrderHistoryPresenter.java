package decorator.ui;

import lombok.RequiredArgsConstructor;
import order.model.Order;
import order.service.IOrderService;

import java.util.List;

@RequiredArgsConstructor
public class OrderHistoryPresenter implements IOrderHistoryPresenter {

    private final IOrderService orderService;

    @Override
    public List<Order> getOrderHistory() {
        return orderService.getOrderHistory();
    }
}
