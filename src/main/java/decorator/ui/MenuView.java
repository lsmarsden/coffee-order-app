package decorator.ui;

import javafx.scene.control.Button;
import lombok.Getter;

public class MenuView extends GenericView {

    @Getter
    private Button startOrderButton = new Button("Start order");

    private Button loginButton = new Button("Log in");
    private Button registerButton = new Button("Register");

    public MenuView(SceneManager sceneManager) {
        super(sceneManager);

        show();
    }

    public void show() {
        startOrderButton.setOnAction(e -> sceneManager.switchScene(new OrderView(sceneManager)));
        loginButton.setOnAction(e -> sceneManager.switchScene(new LoginView(sceneManager)));
        registerButton.setOnAction(e -> sceneManager.switchScene(new RegisterView(sceneManager)));

        root.getChildren().addAll(startOrderButton, loginButton, registerButton);
    }
}
