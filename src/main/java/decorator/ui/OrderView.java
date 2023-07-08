package decorator.ui;

import hibernate.HibernateUtil;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.GridPane;
import order.model.Order;
import order.presenter.IOrderPresenter;
import order.presenter.OrderPresenter;
import order.repository.IOrderRepository;
import order.repository.OrderRepository;
import order.service.IOrderService;
import order.service.OrderService;
import org.hibernate.SessionFactory;
import user.repository.IUserRepository;
import user.repository.UserRepository;
import user.service.IUserService;
import user.service.UserService;

public class OrderView extends GenericView implements IOrderView {
    private Spinner<Integer> milkQuantitySpinner;
    private Spinner<Integer> sugarQuantitySpinner;

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private IOrderRepository orderRepository = new OrderRepository(sessionFactory);

    private IUserRepository userRepository = new UserRepository(sessionFactory);
    private IUserService userService = new UserService(userRepository);

    private IOrderService orderService = new OrderService(orderRepository, userService);

    private IOrderPresenter orderPresenter = new OrderPresenter(orderService, this);

    private Label costLabel = new Label();
    private Label descriptionLabel = new Label();

    private Button submitButton = new Button("Submit");

    private Button orderHistoryButton = new Button("OrderHistory");

    public OrderView(SceneManager sceneManager) {
        super(sceneManager);
    }

    @Override
    public void show() {
        GridPane toppingsGrid = createToppingsGrid();

        submitButton.setOnAction(e -> orderPresenter.submitOrder(milkQuantitySpinner.getValue(), sugarQuantitySpinner.getValue()));
        orderHistoryButton.setOnAction(e -> sceneManager.switchScene(new OrderHistoryView(sceneManager)));
        mainLayout.getChildren().addAll(toppingsGrid, submitButton, costLabel, descriptionLabel, orderHistoryButton);
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
