package org.lsmarsden.decorator.ui;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class RegisterView extends GenericView implements IRegisterView {

    private final IRegisterPresenter registerPresenter;
    private final TextField usernameTextField = new TextField();
    private final TextField passwordTextField = new TextField();
    private final Button submitButton = new Button("Submit");

    public RegisterView(SceneManager sceneManager, IRegisterPresenter registerPresenter) {
        super(sceneManager);
        this.registerPresenter = registerPresenter;
    }

    public void show() {

        usernameTextField.setPromptText("username");
        passwordTextField.setPromptText("password");

        submitButton.setOnAction(e -> {
            registerPresenter.registerUser(usernameTextField.getText(), passwordTextField.getText());
            sceneManager.switchScene(OrderView.class);
        });

        mainLayout.getChildren().addAll(usernameTextField, passwordTextField, submitButton);
    }
}
