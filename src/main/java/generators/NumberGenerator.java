package generators;

import java.util.Random;

/**
 * Generator for strings which are described by regex
 */
public class NumberGenerator extends BaseGenerator<String> {

    /**
     * Common regex which is template for all generated strings.
     * Count of digits for every group will be set in constructor
     */
    private static final String REGEX = "\\d+-\\d+-\\d+";

    /**
     * Divider between groups of digits
     */
    private static final char DIVIDER = '-';

    /**
     * Count of digits for every groups in the string template for result
     */
    private int firstGroup, secondGroup, lastGroup;

    /**
     * Current count of generated strings
     */
    private int currentCount;

    /**
     * Max count of generated strings
     */
    private int maxCount;

    /**
     * Object for a digits generation
     */
    private static Random random = new Random();

    public NumberGenerator(int firstGroup, int secondGroup, int lastGroup, int maxCount) {
        this.maxCount = maxCount;
        this.currentCount = 0;

        this.firstGroup = firstGroup > 0 ? firstGroup : 1;
        this.secondGroup = secondGroup > 0 ? secondGroup : 1;
        this.lastGroup = lastGroup > 0 ? lastGroup : 1;
    }

    @Override
    public boolean hasNext() {
        return currentCount < maxCount;
    }

    @Override
    protected String getNextImplementation() {
        if (hasNext()) {
            currentCount++;
            return getGroup(firstGroup) + DIVIDER +
                    getGroup(secondGroup) + DIVIDER +
                    getGroup(lastGroup);
        }
        return null;
    }

    /**
     * Get the part of result string
     * @param maxCount Max count of digits in this group
     * @return Part of generated value
     */
    private String getGroup(int maxCount) {
        StringBuilder stringBuilder = new StringBuilder(maxCount);
        for (int i = 0; i < maxCount; i++)
            stringBuilder.append((char)('0' + random.nextInt(10)));
        return stringBuilder.toString();
    }
}
