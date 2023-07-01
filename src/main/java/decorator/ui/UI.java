package decorator.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UI extends Application {
    private SceneManager sceneManager;

    @Override
    public void start(Stage primaryStage) {

        sceneManager = new SceneManager(primaryStage);

        Scene scene = new MenuView(sceneManager);


        primaryStage.setTitle("Coffee order");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}
