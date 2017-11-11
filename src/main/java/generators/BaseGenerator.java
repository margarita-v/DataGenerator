package generators;

public abstract class BaseGenerator<T> {

    public abstract boolean hasNext();

    public abstract T getNext();

    protected static String NO_SUCH_ELEMENT_EXCEPTION = "All values were generated!";
}
