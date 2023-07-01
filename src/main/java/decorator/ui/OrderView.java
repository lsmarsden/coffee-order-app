package decorator.ui;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.GridPane;
import org.example.decorator.Coffee;
import org.example.decorator.CoffeeBuilder;
import org.example.decorator.SimpleCoffee;

public class OrderView extends GenericView {
    private Spinner<Integer> milkQuantitySpinner;
    private Spinner<Integer> sugarQuantitySpinner;


    public OrderView(SceneManager sceneManager) {
        super(sceneManager);

        show();
    }

    public void show() {
        Label costLabel = new Label();
        Label descriptionLabel = new Label();

        GridPane toppingsGrid = createToppingsGrid();

        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e -> {
            Coffee coffee = new SimpleCoffee();

            Coffee builtCoffee = CoffeeBuilder.builder(coffee)
                    .milk(milkQuantitySpinner.getValue())
                    .sugar(sugarQuantitySpinner.getValue())
                    .build();
            costLabel.setText("Cost: £" + builtCoffee.getCost());
            descriptionLabel.setText("Order details: " + builtCoffee.getDescription());
        });

        root.getChildren().addAll(toppingsGrid, submitButton, costLabel, descriptionLabel);
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
