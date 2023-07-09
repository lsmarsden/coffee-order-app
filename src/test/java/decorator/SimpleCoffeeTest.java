package decorator;

import org.junit.jupiter.api.Test;
import org.lsmarsden.decorator.SimpleCoffee;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleCoffeeTest {

    private SimpleCoffee underTest = new SimpleCoffee();

    @Test
    void getExtras() {

        // exercise & verify
        assertThat(underTest.getExtras()).isEmpty();
    }

    @Test
    void getCost() {

        // exercise & verify
        assertThat(underTest.getCost()).isEqualTo(1);
    }

    @Test
    void getDescription() {

        // exercise & verify
        assertThat(underTest.getDescription()).isEqualTo("Simple coffee");
    }
}