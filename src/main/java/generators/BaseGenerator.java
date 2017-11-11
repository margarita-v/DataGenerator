package generators;

public abstract class BaseGenerator<T> {

    public abstract boolean hasNext();

    public abstract T getNext();

    /**
     * String value for exception's message
     */
    static String NO_SUCH_ELEMENT_EXCEPTION = "All values were generated!";
}
