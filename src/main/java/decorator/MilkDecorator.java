package decorator;

public class MilkDecorator extends CoffeeDecorator {

    private static final int MAX_QUANTITY = 2;

    public MilkDecorator(Coffee coffee, int quantity) {
        super(coffee, quantity, MAX_QUANTITY);
    }

    @Override
    public double getCost() {
        return super.getCost() + quantity * 0.5;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", " + quantity + "x milk";
    }
}
