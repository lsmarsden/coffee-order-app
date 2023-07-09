package org.lsmarsden.decorator.ui;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.lsmarsden.login.ILoginPresenter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class LoginView extends GenericView implements ILoginView, InitializingBean {


    private final ILoginPresenter loginPresenter;

    private TextField usernameTextField = new TextField();
    private TextField passwordTextField = new TextField();
    private Button submitButton = new Button("Submit");
    private Button registerButton = new Button("Register");

    private Alert alert = new Alert(Alert.AlertType.ERROR);

    public LoginView(SceneManager sceneManager, ILoginPresenter loginPresenter) {
        super(sceneManager);
        this.loginPresenter = loginPresenter;
    }

    @Override
    public void afterPropertiesSet() {
        loginPresenter.setLoginView(this);
    }

    public void show() {

        usernameTextField.setPromptText("username");
        passwordTextField.setPromptText("password");

        submitButton.setOnAction(e -> {
            boolean authenticated = loginPresenter.authenticate(usernameTextField.getText(), passwordTextField.getText());
            if (!authenticated) {
                displayLoginError();
                return;
            }
            sceneManager.switchScene(OrderView.class);
        });

        registerButton.setOnAction(e -> sceneManager.switchScene(RegisterView.class));
        mainLayout.getChildren().addAll(usernameTextField, passwordTextField, submitButton, registerButton);
    }

    public void displayLoginError() {
        alert.setContentText("Invalid username/password");
        alert.showAndWait();
    }

}
