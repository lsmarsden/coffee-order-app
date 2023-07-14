package org.lsmarsden.decorator.app;

import javafx.application.Application;
import javafx.stage.Stage;
import org.lsmarsden.decorator.ui.LoginView;
import org.lsmarsden.decorator.ui.SceneManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class, UserDetailsServiceAutoConfiguration.class})
public class Main extends Application {

    private ConfigurableApplicationContext context;

    public static void main(String[] args) {
        Application.launch(Main.class, args);
    }

    @Override
    public void start(Stage primaryStage) {

        SceneManager sceneManager = context.getBean(SceneManager.class);
        sceneManager.setPrimaryStage(primaryStage);
        primaryStage.setTitle("Coffee order");
        primaryStage.show();
        sceneManager.switchScene(LoginView.class);
    }

    @Override
    public void init() {
        context = SpringApplication.run(Main.class);
    }

    @Override
    public void stop() {
        context.close();
    }
}
