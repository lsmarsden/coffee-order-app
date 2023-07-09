package org.lsmarsden.decorator;

import java.util.EnumMap;
import java.util.Map;

public class SimpleCoffee implements Coffee {

    private Map<Topping, Integer> extras = new EnumMap<>(Topping.class);

    @Override
    public double getCost() {
        return 1;
    }

    @Override
    public String getDescription() {
        return "Simple coffee";
    }

    @Override
    public Map<Topping, Integer> getExtras() {
        return extras;
    }
}
