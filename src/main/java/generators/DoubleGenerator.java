package generators;

import java.util.NoSuchElementException;
import java.util.Random;

public class DoubleGenerator extends BaseGenerator<Double> {

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Double getNext() throws NoSuchElementException {
        if (hasNext())
            return new Random().nextDouble();
        throw new NoSuchElementException(NO_SUCH_ELEMENT_EXCEPTION);
    }
}
