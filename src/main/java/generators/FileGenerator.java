package generators;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FileGenerator extends BaseGenerator<String> {

    private Scanner scanner;

    public FileGenerator(File file) {
        try {
            this.scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //region BaseGenerator implementation
    public boolean hasNext() {
        return scanner.hasNext();
    }

    public String getNext() {
        if (hasNext())
            return scanner.next();
        throw new NoSuchElementException(NO_SUCH_ELEMENT_EXCEPTION);
    }
    //endregion
}
