package decorator;

import order.model.Order;

public class OrderPresenter implements IOrderPresenter {

    private final IOrderService orderService;
    private final IOrderView orderView;

    public OrderPresenter(IOrderService orderService, IOrderView orderView) {
        this.orderService = orderService;
        this.orderView = orderView;
        this.orderView.setOrderPresenter(this);
    }

    @Override
    public void submitOrder(int milkQuantity, int sugarQuantity) {

        Order order = orderService.createOrder(milkQuantity, sugarQuantity);
        orderView.displayOrderDetails(order);
    }
}
