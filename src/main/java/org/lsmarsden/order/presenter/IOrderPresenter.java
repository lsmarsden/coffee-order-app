package org.lsmarsden.order.presenter;

import org.lsmarsden.decorator.ui.IOrderView;

public interface IOrderPresenter {

    void submitOrder(int milkQuantity, int sugarQuantity);

    void setOrderView(IOrderView orderView);
}
