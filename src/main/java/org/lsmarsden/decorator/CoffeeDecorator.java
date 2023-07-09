package org.lsmarsden.decorator;

import java.util.Map;

public abstract class CoffeeDecorator implements Coffee {

    protected Coffee coffee;
    protected int quantity;

    protected CoffeeDecorator(Coffee coffee, int quantity, int maxQuantity) {
        if (quantity > maxQuantity) {
            throw new ToppingQuantityExceededException();
        }
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity has minimum zero.");
        }

        this.coffee = coffee;
        this.quantity = quantity;
    }

    @Override
    public double getCost() {
        return coffee.getCost();
    }

    @Override
    public String getDescription() {
        return coffee.getDescription();
    }

    @Override
    public Map<Topping, Integer> getExtras() {
        return coffee.getExtras();
    }
}
