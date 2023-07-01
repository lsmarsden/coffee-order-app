package decorator;

import lombok.NonNull;

public class CoffeeBuilder {


    private Coffee coffee;
    private boolean milk;

    private CoffeeBuilder(Coffee coffee) {
        this.coffee = coffee;
    }

    public static CoffeeBuilder builder(@NonNull Coffee coffee) {
        return new CoffeeBuilder(coffee);
    }

    public CoffeeBuilder sugar(int quantity) {
        validateTopping(Topping.SUGAR);
        this.coffee = new SugarDecorator(coffee, quantity);
        coffee.getExtras().put(Topping.SUGAR, quantity);

        return this;
    }

    public CoffeeBuilder milk(int quantity) {
        validateTopping(Topping.MILK);
        this.coffee = new MilkDecorator(coffee, quantity);
        coffee.getExtras().put(Topping.MILK, quantity);

        return this;
    }

    private void validateTopping(Topping topping) {
        if (coffee.getExtras().containsKey(topping)) {
            throw new ToppingAlreadyAppliedException(topping);
        }
    }

    public Coffee build() {
        return this.coffee;
    }
}
