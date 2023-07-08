package decorator.ui;

import javafx.application.Application;
import javafx.stage.Stage;

public class UI extends Application {
    private SceneManager sceneManager;


    @Override
    public void start(Stage primaryStage) {


        sceneManager = new SceneManager(primaryStage);
        GenericView scene = new LoginView(sceneManager);

        primaryStage.setTitle("Coffee order");
        primaryStage.setScene(scene);
        primaryStage.show();
        sceneManager.switchScene(scene);
    }


}
