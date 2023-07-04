package decorator.ui;

import hibernate.HibernateUtil;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import login.ILoginPresenter;
import login.ILoginService;
import login.LoginPresenter;
import login.LoginService;
import user.repository.IUserRepository;
import user.repository.UserRepository;

public class LoginView extends GenericView implements ILoginView {

    private IUserRepository userRepository = new UserRepository(HibernateUtil.getSessionFactory());
    private ILoginService loginService = new LoginService(userRepository);


    private ILoginPresenter loginPresenter = new LoginPresenter(this, loginService);
    private TextField usernameTextField = new TextField("username");
    private TextField passwordTextField = new TextField("password");
    private Button submitButton = new Button("Submit");

    private Alert alert = new Alert(Alert.AlertType.ERROR);

    public LoginView(SceneManager sceneManager) {
        super(sceneManager);

        show();
    }

    @Override
    public void setLoginPresenter(ILoginPresenter loginPresenter) {
        this.loginPresenter = loginPresenter;
    }

    public void show() {
        submitButton.setOnAction(e -> {
            boolean authenticated = loginPresenter.authenticate(usernameTextField.getText(), passwordTextField.getText());
            if (!authenticated) {
                displayLoginError();
                return;
            }
            sceneManager.switchScene(new OrderView(sceneManager));
        });

        root.getChildren().addAll(usernameTextField, passwordTextField, submitButton);
    }

    public void displayLoginError() {
        alert.setContentText("Invalid username/password");
        alert.showAndWait();
    }

}
