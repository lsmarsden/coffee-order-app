package decorator.ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import session.AuthenticationManager;
import session.IAuthenticationManager;

@RequiredArgsConstructor
@Setter
public class SceneManager {
    private final Stage primaryStage;

    private final IAuthenticationManager authenticationManager = new AuthenticationManager();


    private EventHandler<ActionEvent> sceneSwitchedEventHandler;

    public void switchScene(GenericView scene) {
        if (!authenticationManager.isAuthenticated() && !(scene instanceof IUnauthenticatedView)) {
            redirectToLoginView();
            return;
        }

        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        scene.show();

        if (sceneSwitchedEventHandler != null) {
            sceneSwitchedEventHandler.handle(new ActionEvent(scene, null));
        }
    }

    private void redirectToLoginView() {
        System.out.println("redirecting unauthenticated user to login");
        switchScene(new LoginView(this));
    }


}
