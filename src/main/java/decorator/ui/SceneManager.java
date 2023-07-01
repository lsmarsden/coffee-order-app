package decorator.ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Setter
public class SceneManager {
    private final Stage primaryStage;

    private EventHandler<ActionEvent> sceneSwitchedEventHandler;

    public void switchScene(Scene scene) {
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();

        if (sceneSwitchedEventHandler != null) {
            sceneSwitchedEventHandler.handle(new ActionEvent(scene, null));
        }
    }


}
