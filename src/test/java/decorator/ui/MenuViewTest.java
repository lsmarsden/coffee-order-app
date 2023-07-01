package decorator.ui;

import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.testfx.api.FxAssert;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.matcher.control.LabeledMatchers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;

@ExtendWith({MockitoExtension.class, ApplicationExtension.class})
class MenuViewTest {

    private MenuView underTest;

    @Mock
    private SceneManager sceneManager;

    @Start
    private void start(Stage stage) {
        underTest = new MenuView(sceneManager);
        stage.setScene(underTest);
        stage.show();
    }

    @Test
    void constructorShouldSetupLayout() {

        // verify
        Button startOrderButton = underTest.getStartOrderButton();
        FxAssert.verifyThat(startOrderButton, LabeledMatchers.hasText("Start order"));
        assertThat(startOrderButton.getText()).isEqualTo("Start order");

        verifyNoInteractions(sceneManager);
        startOrderButton.getOnAction().handle(null);
        verify(sceneManager).switchScene(any(OrderView.class));

    }
}