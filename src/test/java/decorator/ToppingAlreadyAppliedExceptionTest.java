package decorator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.lsmarsden.decorator.Topping;
import org.lsmarsden.decorator.ToppingAlreadyAppliedException;

import static org.assertj.core.api.Assertions.assertThat;

class ToppingAlreadyAppliedExceptionTest {

    private ToppingAlreadyAppliedException underTest;

    @ParameterizedTest
    @EnumSource(Topping.class)
    void message(Topping topping) {

        // exercise
        underTest = new ToppingAlreadyAppliedException(topping);

        // verify
        assertThat(underTest).hasMessage(topping + " has already been added.");
    }
}