package decorator.ui;

import hibernate.HibernateUtil;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import order.model.Order;
import order.repository.IOrderRepository;
import order.repository.OrderRepository;
import order.service.IOrderService;
import order.service.OrderService;
import org.hibernate.SessionFactory;
import user.repository.IUserRepository;
import user.repository.UserRepository;
import user.service.IUserService;
import user.service.UserService;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class OrderHistoryView extends GenericView {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private IOrderRepository orderRepository = new OrderRepository(sessionFactory);
    private IUserRepository userRepository = new UserRepository(sessionFactory);
    private IUserService userService = new UserService(userRepository);
    private IOrderService orderService = new OrderService(orderRepository, userService);
    private final IOrderHistoryPresenter orderHistoryPresenter = new OrderHistoryPresenter(orderService);
    private GridPane orderHistoryGrid;

    public OrderHistoryView(SceneManager sceneManager) {
        super(sceneManager);
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
