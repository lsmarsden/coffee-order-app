package decorator;

import java.util.Map;

public interface Coffee {

    double getCost();

    String getDescription();

    Map<Topping, Integer> getExtras();

}
