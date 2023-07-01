package decorator;

public class ToppingAlreadyAppliedException extends IllegalArgumentException {

    public ToppingAlreadyAppliedException(Topping topping) {
        super(topping + " has already been added.");
    }
}
