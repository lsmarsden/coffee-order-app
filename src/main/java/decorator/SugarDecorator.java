package decorator;

public class SugarDecorator extends CoffeeDecorator {

    private static final int MAX_QUANTITY = 5;

    public SugarDecorator(Coffee coffee, int quantity) {
        super(coffee, quantity, MAX_QUANTITY);
    }

    @Override
    public double getCost() {
        return super.getCost() + quantity * 0.25;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", " + quantity + "x sugar";
    }
}
