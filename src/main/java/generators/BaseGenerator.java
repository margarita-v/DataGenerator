package generators;

public abstract class BaseGenerator<T> {

    public abstract boolean hasNext();

    public abstract T getNext();

    public void printAll() {
        T item;
        while ((item = getNext()) != null) {
            System.out.println(item.toString());
        }
        System.out.println();
    }
}
