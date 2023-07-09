package org.lsmarsden.decorator.ui;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.GridPane;
import org.lsmarsden.order.model.Order;
import org.lsmarsden.order.presenter.IOrderPresenter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class OrderView extends GenericView implements IOrderView, InitializingBean {
    private final Label costLabel = new Label();
    private final Label descriptionLabel = new Label();
    private final Button submitButton = new Button("Submit");
    private final Button orderHistoryButton = new Button("OrderHistory");
    private final IOrderPresenter orderPresenter;
    private Spinner<Integer> milkQuantitySpinner;
    private Spinner<Integer> sugarQuantitySpinner;

    public OrderView(SceneManager sceneManager, IOrderPresenter orderPresenter) {
        super(sceneManager);
        this.orderPresenter = orderPresenter;
    }

    @Override
    public void afterPropertiesSet() {
        orderPresenter.setOrderView(this);
    }

    @Override
    public void show() {
        GridPane toppingsGrid = createToppingsGrid();

        submitButton.setOnAction(e -> orderPresenter.submitOrder(milkQuantitySpinner.getValue(), sugarQuantitySpinner.getValue()));
        orderHistoryButton.setOnAction(e -> sceneManager.switchScene(OrderHistoryView.class));
        mainLayout.getChildren().addAll(toppingsGrid, submitButton, costLabel, descriptionLabel, orderHistoryButton);
    }

    @Override
    public void displayOrderDetails(Order order) {
        costLabel.setText("Cost: £" + order.getCost());
        descriptionLabel.setText("Order details: " + order.getDescription());
    }

    private GridPane createToppingsGrid() {
        GridPane toppingsGrid = new GridPane();
        toppingsGrid.setHgap(10);
        toppingsGrid.setVgap(5);

        Label milkLabel = new Label("Milk:");
        this.milkQuantitySpinner = new Spinner<>();
        milkQuantitySpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0));

        Label sugarLabel = new Label("Sugar:");
        this.sugarQuantitySpinner = new Spinner<>();
        sugarQuantitySpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0));

        toppingsGrid.addRow(0, milkLabel, milkQuantitySpinner);
        toppingsGrid.addRow(1, sugarLabel, sugarQuantitySpinner);

        return toppingsGrid;
    }
}
