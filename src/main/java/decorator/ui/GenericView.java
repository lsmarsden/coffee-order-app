package decorator.ui;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;

public abstract class GenericView extends Scene {
    protected VBox root;
    protected SceneManager sceneManager;

    protected GenericView() {
        super(new VBox(), 300, 200);
        this.root = (VBox) getRoot();
    }

    protected GenericView(SceneManager sceneManager) {
        this();
        this.sceneManager = sceneManager;
    }
}
