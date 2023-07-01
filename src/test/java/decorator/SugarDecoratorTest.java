package decorator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class SugarDecoratorTest {

    private SugarDecorator underTest;

    private Coffee coffee = new SimpleCoffee();

    @Test
    void quantityMustBeNonNegativeAndLessThanFive() {

        // exercise & verify
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new SugarDecorator(coffee, -1))
                .withMessage("Quantity has minimum zero.");
        assertThatExceptionOfType(ToppingQuantityExceededException.class)
                .isThrownBy(() -> new SugarDecorator(coffee, 6));

    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void getCostShouldIncreaseWithQuantity(int quantity) {

        // exercise
        underTest = new SugarDecorator(coffee, quantity);

        // verify
        assertThat(underTest.getCost()).isEqualTo(coffee.getCost() + 0.25 * quantity);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void getDescriptionShouldUpdateWithQuantity(int quantity) {

        // exercise
        underTest = new SugarDecorator(coffee, quantity);

        // verify
        assertThat(underTest.getDescription()).isEqualTo(coffee.getDescription() + ", " + quantity + "x sugar");
    }
}