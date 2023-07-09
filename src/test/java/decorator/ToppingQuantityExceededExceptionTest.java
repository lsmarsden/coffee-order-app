package decorator;

import org.junit.jupiter.api.Test;
import org.lsmarsden.decorator.ToppingQuantityExceededException;

import static org.assertj.core.api.Assertions.assertThat;

class ToppingQuantityExceededExceptionTest {

    private ToppingQuantityExceededException underTest;

    @Test
    void message() {

        // set up


        // exercise
        underTest = new ToppingQuantityExceededException();

        // verify
        assertThat(underTest).hasMessage("Topping quantity exceeded");
    }
}