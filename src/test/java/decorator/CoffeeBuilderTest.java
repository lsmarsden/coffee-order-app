package decorator;

import org.junit.jupiter.api.Test;
import org.lsmarsden.decorator.*;

import static org.assertj.core.api.Assertions.*;

class CoffeeBuilderTest {

    private Coffee coffee = new SimpleCoffee();

    @Test
    void coffeeMustNotBeNull() {

        // exercise & verify
        assertThatNullPointerException()
                .isThrownBy(() -> CoffeeBuilder.builder(null).build());
    }

    @Test
    void buildWithCoffee() {

        // exercise
        Coffee build = CoffeeBuilder.builder(coffee)
                .build();

        // verify
        assertThat(build.getCost()).isEqualTo(1);
        assertThat(build.getDescription()).isEqualTo("Simple coffee");
    }

    @Test
    void buildWithSugar() {

        // set up
        Coffee expectedCoffee = new SugarDecorator(coffee, 2);

        // exercise
        Coffee actualCoffee = CoffeeBuilder.builder(coffee)
                .sugar(2)
                .build();

        // verify
        assertThat(actualCoffee.getCost()).isEqualTo(expectedCoffee.getCost());
        assertThat(actualCoffee.getDescription()).isEqualTo(expectedCoffee.getDescription());
        assertThat(actualCoffee.getExtras()).containsEntry(Topping.SUGAR, 2);
    }

    @Test
    void buildWithMilk() {

        // set up
        Coffee expectedCoffee = new MilkDecorator(coffee, 2);

        // exercise
        Coffee actualCoffee = CoffeeBuilder.builder(coffee)
                .milk(2)
                .build();

        // verify
        assertThat(actualCoffee.getCost()).isEqualTo(expectedCoffee.getCost());
        assertThat(actualCoffee.getDescription()).isEqualTo(expectedCoffee.getDescription());
        assertThat(actualCoffee.getExtras()).containsEntry(Topping.MILK, 2);
    }

    @Test
    void buildAll() {

        // set up
        Coffee expectedCoffee = new SugarDecorator(new MilkDecorator(coffee, 1), 2);

        // exercise
        Coffee actualCoffee = CoffeeBuilder.builder(coffee)
                .milk(1)
                .sugar(2)
                .build();

        // verify
        assertThat(actualCoffee.getCost()).isEqualTo(expectedCoffee.getCost());
        assertThat(actualCoffee.getDescription()).isEqualTo(expectedCoffee.getDescription());
    }

    @Test
    void buildMultipleSugarShouldNotAddTwice() {

        // exercise & verify
        assertThatIllegalArgumentException().isThrownBy(() -> CoffeeBuilder.builder(coffee)
                        .sugar(2)
                        .sugar(2))
                .withMessage("SUGAR has already been added.");
    }

    @Test
    void buildMultipleMilkShouldNotAddTwice() {

        // exercise & verify
        assertThatIllegalArgumentException().isThrownBy(() -> CoffeeBuilder.builder(coffee)
                        .milk(2)
                        .milk(2))
                .withMessage("MILK has already been added.");
    }
}