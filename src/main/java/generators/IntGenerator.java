package generators;

import java.util.NoSuchElementException;

public class IntGenerator extends BaseGenerator<Integer> {

    /**
     * Max value for generated values
     */
    private int maxValue;

    /**
     * Step for a current value change
     */
    private int step = 1;

    /**
     * Current value which will be returned in getNext() method
     */
    private int currentValue;

    //region Constructors
    public IntGenerator(int minValue, int maxValue) {
        this.maxValue = maxValue;
        this.currentValue = minValue;
    }

    public IntGenerator(int minValue, int maxValue, int step) {
        this(minValue, maxValue);
        this.step = step;
    }
    //endregion

    //region BaseGenerator implementation
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
    //endregion

    //region Setters
    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public void setStep(int step) {
        this.step = step;
    }
    //endregion
}
