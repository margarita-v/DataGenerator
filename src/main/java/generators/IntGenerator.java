package generators;

public class IntGenerator extends BaseGenerator<Integer> {

    /**
     * Current value which will be returned in getNext() method
     */
    private int currentValue;

    /**
     * Max value for generated values
     */
    private int maxValue;

    /**
     * Step for a current value change
     */
    private int step = 1;

    //region Constructors
    public IntGenerator(int minValue, int maxValue) {
        if (minValue < maxValue) {
            this.currentValue = minValue;
            this.maxValue = maxValue;
        } else {
            this.currentValue = maxValue;
            this.maxValue = minValue;
        }
    }

    public IntGenerator(int minValue, int maxValue, int step) {
        this(minValue, maxValue);
        this.step = step;
    }
    //endregion

    @Override
    public boolean hasNext() {
        return currentValue < maxValue;
    }

    @Override
    protected Integer getNextImplementation() {
        if (hasNext()) {
            int result = currentValue;
            currentValue += step;
            return result;
        }
        return null;
    }
}
