package decorator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.EnumMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CoffeeDecoratorTest {

    private CoffeeDecorator underTest;

    @Mock
    private Coffee coffee;

    private int quantity = 1;

    private int maxQuantity = 5;

    @BeforeEach
    void setup() {
        underTest = new CoffeeDecorator(coffee, quantity, maxQuantity) {
        };
    }

    @Test
    void constructorShouldValidateMaximumQuantity() {

        // set up
        int maxQuantity = 5;
        int quantity = 6;

        // exercise & verify
        assertThatExceptionOfType(ToppingQuantityExceededException.class)
                .isThrownBy(() -> new CoffeeDecorator(coffee, quantity, maxQuantity) {
                });
    }

    @Test
    void constructorShouldValidateMinimumQuantity() {

        // set up
        int maxQuantity = 5;
        int quantity = -1;

        // exercise & verify
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new CoffeeDecorator(coffee, quantity, maxQuantity) {
                })
                .withMessage("Quantity has minimum zero.");
    }

    @Test
    void getCost() {

        // set up
        double cost = 3;
        when(coffee.getCost()).thenReturn(cost);


        // exercise & verify
        assertThat(underTest.getCost()).isEqualTo(cost);
    }

    @Test
    void getDescription() {

        // set up
        String description = "desc";
        when(coffee.getDescription()).thenReturn(description);

        // exercise & verify
        assertThat(underTest.getDescription()).isEqualTo(description);
    }

    @Test
    void getExtras() {

        // set up
        Map<Topping, Integer> extras = new EnumMap<>(Topping.class);
        when(coffee.getExtras()).thenReturn(extras);

        // exercise & verify
        assertThat(underTest.getExtras()).isEqualTo(extras);
    }
}