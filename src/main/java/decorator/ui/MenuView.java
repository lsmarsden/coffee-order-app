package decorator.ui;

import javafx.scene.control.Button;
import lombok.Getter;

public class MenuView extends GenericView {

    @Getter
    private Button startOrderButton;

    public MenuView(SceneManager sceneManager) {
        super(sceneManager);
        startOrderButton = new Button("Start order");

        startOrderButton.setOnAction(e -> sceneManager.switchScene(new OrderView(sceneManager)));

        root.getChildren().add(startOrderButton);
    }
}
