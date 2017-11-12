package generators;

public abstract class BaseGenerator<T> {

    /**
     * Object for thread safe usage
     */
    private final Object lock = new Object();

    /**
     * Function which checks if the next generator's value could be get
     * @return True if we can get the next value
     */
    public abstract boolean hasNext();

    /**
     * Function for getting next value with a thread safe implementation
     * @return Next value or null if we have already got all values
     */
    public T getNext() {
        synchronized (lock) {
            return getNextImplementation();
        }
    }

    /**
     * Implementation of getting next value which depends on a concrete generator
     * @return Next value or null if we have already got all values
     */
    protected abstract T getNextImplementation();

    /**
     * Helpful function for simple iteration through all generator's values
     */
    public void printAll() {
        T item;
        while ((item = getNext()) != null) {
            System.out.println(item);
        }
        System.out.println();
    }
}
