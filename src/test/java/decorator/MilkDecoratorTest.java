package decorator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.lsmarsden.decorator.Coffee;
import org.lsmarsden.decorator.MilkDecorator;
import org.lsmarsden.decorator.SimpleCoffee;
import org.lsmarsden.decorator.ToppingQuantityExceededException;

import static org.assertj.core.api.Assertions.*;

class MilkDecoratorTest {
    private MilkDecorator underTest;

    private Coffee coffee = new SimpleCoffee();

    @Test
    void quantityMustBeNonNegativeAndLessThanThree() {

        // exercise & verify
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new MilkDecorator(coffee, -1))
                .withMessage("Quantity has minimum zero.");
        assertThatExceptionOfType(ToppingQuantityExceededException.class)
                .isThrownBy(() -> new MilkDecorator(coffee, 3));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    void getCostShouldIncreaseWithQuantity(int quantity) {

        // exercise
        underTest = new MilkDecorator(coffee, quantity);

        // verify
        assertThat(underTest.getCost()).isEqualTo(coffee.getCost() + 0.5 * quantity);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    void getDescriptionShouldUpdateWithQuantity(int quantity) {

        // exercise
        underTest = new MilkDecorator(coffee, quantity);

        // verify
        assertThat(underTest.getDescription()).isEqualTo(coffee.getDescription() + ", " + quantity + "x milk");
    }
}