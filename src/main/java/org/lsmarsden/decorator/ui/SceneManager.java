package org.lsmarsden.decorator.ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.lsmarsden.session.IAuthenticationManager;

import java.util.Deque;
import java.util.LinkedList;

@Component
@RequiredArgsConstructor
@Setter
public class SceneManager implements ApplicationContextAware {
    private final IAuthenticationManager authenticationManager;
    private final Deque<GenericView> sceneHistory = new LinkedList<>();
    private Stage primaryStage;
    private EventHandler<ActionEvent> sceneSwitchedEventHandler;
    private GenericView currentScene;
    private ApplicationContext applicationContext;

    public void switchScene(GenericView newScene) {
        navigateToScene(newScene.getClass(), true);
    }

    public void switchScene(Class<? extends GenericView> sceneClass) {
        navigateToScene(sceneClass, true);
    }

    private void navigateToScene(Class<? extends GenericView> newSceneClass, boolean navigatingForwards) {
        if (!authenticationManager.isAuthenticated() && !(IUnauthenticatedView.class.isAssignableFrom(newSceneClass))) {
            redirectToLoginView();
            return;
        }

        if (navigatingForwards) {
            sceneHistory.add(currentScene);
        }

        GenericView newScene = applicationContext.getBean(newSceneClass);

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

        navigateToScene(previousScene.getClass(), false);
    }

    private void redirectToLoginView() {
        System.out.println("redirecting unauthenticated user to login");
        switchScene(LoginView.class);
    }


}
