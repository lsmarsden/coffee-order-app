package decorator.ui;

import decorator.*;
import hibernate.HibernateUtil;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.GridPane;
import order.model.Order;
import repository.IOrderRepository;
import repository.OrderRepository;

public class OrderView extends GenericView implements IOrderView {
    private Spinner<Integer> milkQuantitySpinner;
    private Spinner<Integer> sugarQuantitySpinner;

    private IOrderRepository orderRepository = new OrderRepository(HibernateUtil.getSessionFactory());

    private IOrderService orderService = new OrderService(orderRepository);

    private IOrderPresenter orderPresenter = new OrderPresenter(orderService, this);

    private Label costLabel = new Label();
    private Label descriptionLabel = new Label();

    public OrderView(SceneManager sceneManager) {
        super(sceneManager);

        show();
    }

    @Override
    public void show() {
        GridPane toppingsGrid = createToppingsGrid();

        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e -> orderPresenter.submitOrder(milkQuantitySpinner.getValue(), sugarQuantitySpinner.getValue()));

        root.getChildren().addAll(toppingsGrid, submitButton, costLabel, descriptionLabel);
    }

    @Override
    public void displayOrderDetails(Order order) {
        costLabel.setText("Cost: £" + order.getCost());
        descriptionLabel.setText("Order details: " + order.getDescription());
    }

    @Override
    public void setOrderPresenter(IOrderPresenter orderPresenter) {
        this.orderPresenter = orderPresenter;
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
