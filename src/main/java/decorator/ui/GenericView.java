package decorator.ui;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public abstract class GenericView extends Scene {
    protected BorderPane root;

    protected Pane mainLayout = new VBox();

    protected SceneManager sceneManager;

    protected GenericView(SceneManager sceneManager) {
        super(new BorderPane(), 600, 400);
        this.root = (BorderPane) getRoot();

        this.sceneManager = sceneManager;

        FooterPane footerPane = new FooterPane(sceneManager);
        root.setBottom(footerPane);
        root.setCenter(mainLayout);
    }

    public abstract void show();

    public void refresh() {
        mainLayout.getChildren().clear();
        show();
    }

}
