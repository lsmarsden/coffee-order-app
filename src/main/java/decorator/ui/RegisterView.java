package decorator.ui;

import hibernate.HibernateUtil;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import user.repository.IUserRepository;
import user.repository.UserRepository;
import user.service.UserService;

public class RegisterView extends GenericView implements IRegisterView {

    private final IUserRepository userRepository = new UserRepository(HibernateUtil.getSessionFactory());
    private final UserService userService = new UserService(userRepository);
    private final RegisterPresenter registerPresenter = new RegisterPresenter(userService);
    private TextField usernameTextField = new TextField("username");
    private TextField passwordTextField = new TextField("password");
    private Button submitButton = new Button("Submit");

    public RegisterView(SceneManager sceneManager) {
        super(sceneManager);
    }

    public void show() {

        submitButton.setOnAction(e -> {
            registerPresenter.registerUser(usernameTextField.getText(), passwordTextField.getText());
            sceneManager.switchScene(new OrderView(sceneManager));
        });

        root.getChildren().addAll(usernameTextField, passwordTextField, submitButton);
    }
}
