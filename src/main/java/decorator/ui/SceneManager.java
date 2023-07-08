package decorator.ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import session.AuthenticationManager;
import session.IAuthenticationManager;

import java.util.Deque;
import java.util.LinkedList;

@RequiredArgsConstructor
@Setter
public class SceneManager {
    private final Stage primaryStage;

    private final IAuthenticationManager authenticationManager = new AuthenticationManager();
    private final Deque<GenericView> sceneHistory = new LinkedList<>();
    private EventHandler<ActionEvent> sceneSwitchedEventHandler;
    private GenericView currentScene;

    public void switchScene(GenericView newScene) {
        navigateToScene(newScene, true);
    }

    private void navigateToScene(GenericView newScene, boolean navigatingForwards) {
        if (!authenticationManager.isAuthenticated() && !(newScene instanceof IUnauthenticatedView)) {
            redirectToLoginView();
            return;
        }

        if (navigatingForwards) {
            sceneHistory.add(currentScene);
        }

        primaryStage.setScene(newScene);
        primaryStage.centerOnScreen();
        newScene.refresh();
        currentScene = newScene;

        if (sceneSwitchedEventHandler != null) {
            sceneSwitchedEventHandler.handle(new ActionEvent(newScene, null));
        }
    }

    // currently uses the same instance of the scene
    // benefit of the same instance is it has all the text and input stored (good or bad thing?)
    public void navigateToPreviousScene() {
        GenericView previousScene = sceneHistory.pollLast();
        if (previousScene == null) {
            return;
        }

        navigateToScene(previousScene, false);
    }

    private void redirectToLoginView() {
        System.out.println("redirecting unauthenticated user to login");
        switchScene(new LoginView(this));
    }


}
