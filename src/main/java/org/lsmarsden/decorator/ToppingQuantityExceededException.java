package org.lsmarsden.decorator;

public class ToppingQuantityExceededException extends IllegalArgumentException {

    public ToppingQuantityExceededException() {
        super("Topping quantity exceeded");
    }
}
