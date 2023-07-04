package decorator.ui;

import order.presenter.IOrderPresenter;
import order.model.Order;

public interface IOrderView {

    void show();

    void setOrderPresenter(IOrderPresenter orderPresenter);

    void displayOrderDetails(Order order);
}
