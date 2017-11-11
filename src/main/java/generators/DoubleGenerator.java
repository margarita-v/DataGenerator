package generators;

import java.util.NoSuchElementException;
import java.util.Random;

public class DoubleGenerator extends BaseGenerator<Double> {

    public boolean hasNext() {
        return true;
    }

    public Double getNext() {
        if (hasNext())
            return new Random().nextDouble();
        throw new NoSuchElementException(NO_SUCH_ELEMENT_EXCEPTION);
    }
}
