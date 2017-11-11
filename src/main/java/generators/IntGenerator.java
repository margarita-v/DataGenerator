package generators;

import java.util.NoSuchElementException;

public class IntGenerator extends BaseGenerator<Integer> {

    private int minValue;

    private int maxValue;

    private int step = 1;

    private int currentValue;

    public IntGenerator(int minValue, int maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.currentValue = minValue;
    }

    public IntGenerator(int minValue, int maxValue, int step) {
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.currentValue = minValue;
        this.step = step;
    }

    public boolean hasNext() {
        return currentValue < maxValue;
    }

    public Integer getNext() {
        if (hasNext()) {
            int result = currentValue;
            currentValue += step;
            return result;
        }
        throw new NoSuchElementException(NO_SUCH_ELEMENT_EXCEPTION);
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public void setStep(int step) {
        this.step = step;
    }
}
