package generators;

/**
 * Generator for double values in a concrete range
 */
public class DoubleGenerator extends BaseGenerator<Double> {

    /**
     * Current value which will be returned in getNext() method
     */
    private double currentValue;

    /**
     * Max value for generated values
     */
    private double maxValue;

    /**
     * Step for a current value change
     */
    private double step = 0.1;

    /**
     * Precision for comparison of two double values
     */
    private static final double EPS = 0.0000001;

    //region Constructors
    public DoubleGenerator(double minValue, double maxValue) {
        if (maxValue - minValue > EPS) {
            this.currentValue = minValue;
            this.maxValue = maxValue;
        }
        else {
            this.currentValue = maxValue;
            this.maxValue = minValue;
        }
    }

    public DoubleGenerator(double currentValue, double maxValue, double step) {
        this(currentValue, maxValue);
        this.step = step;
    }
    //endregion

    @Override
    public boolean hasNext() {
        return maxValue - currentValue > EPS;
    }

    @Override
    protected Double getNextImplementation() {
        if (hasNext()) {
            double result = currentValue;
            currentValue += step;
            return result;
        }
        return null;
    }
}
