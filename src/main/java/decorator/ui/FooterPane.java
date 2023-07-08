package decorator.ui;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class FooterPane extends VBox {

    private final SceneManager sceneManager;
    private Button backButton = new Button("Back");

    public FooterPane(SceneManager sceneManager) {
        this.sceneManager = sceneManager;

        backButton.setOnAction(e -> sceneManager.navigateToPreviousScene());

        getChildren().add(backButton);
    }
}
