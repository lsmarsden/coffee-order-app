package org.lsmarsden.decorator.ui;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import org.lsmarsden.order.model.Order;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class OrderHistoryView extends GenericView {


    private final IOrderHistoryPresenter orderHistoryPresenter;
    private GridPane orderHistoryGrid;

    public OrderHistoryView(SceneManager sceneManager, IOrderHistoryPresenter orderHistoryPresenter) {
        super(sceneManager);
        this.orderHistoryPresenter = orderHistoryPresenter;
    }

    @Override
    public void show() {

        createOrderHistoryGrid();

        mainLayout.getChildren().add(orderHistoryGrid);
    }

    private void createOrderHistoryGrid() {
        orderHistoryGrid = new GridPane();
        orderHistoryGrid.setGridLinesVisible(true);
        orderHistoryGrid.setPadding(new Insets(10));


        Label orderHeader = new Label("Order no.");
        Label costHeader = new Label("Cost");
        Label descriptionHeader = new Label("Description");
        Label orderDateHeader = new Label("Order date");

        orderHistoryGrid.addRow(0, orderHeader, costHeader, descriptionHeader, orderDateHeader);

        List<Order> orderHistory = orderHistoryPresenter.getOrderHistory();

        int row = 1;
        for (Order order : orderHistory) {
            addOrderToGrid(row, order);
            row++;
        }
    }

    private void addOrderToGrid(int row, Order order) {
        Label orderId = new Label(String.valueOf(order.getId()));
        Label costLabel = new Label("£" + order.getCost());
        Label descriptionLabel = new Label(order.getDescription());
        Label orderDateLabel = new Label(order.getOrderDate().format(DateTimeFormatter.ISO_LOCAL_DATE));

        orderHistoryGrid.addRow(row, orderId, costLabel, descriptionLabel, orderDateLabel);
    }
}
