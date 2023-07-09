package decorator;

import org.junit.jupiter.api.Test;
import org.lsmarsden.decorator.Topping;

import static org.assertj.core.api.Assertions.assertThat;

class ToppingTest {


    @Test
    void values() {

        // exercise & verify
        assertThat(Topping.values()).containsExactlyInAnyOrder(Topping.SUGAR, Topping.MILK);
    }
}