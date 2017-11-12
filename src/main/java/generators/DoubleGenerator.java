package generators;

import java.util.Random;

public class DoubleGenerator extends BaseGenerator<Double> {

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Double getNext() {
        if (hasNext())
            return new Random().nextDouble();
        return null;
    }
}
