package generators;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Generator for all words in a concrete file
 */
public class FileGenerator extends BaseGenerator<String> {

    private Scanner scanner;

    public FileGenerator(File file) {
        try {
            this.scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean hasNext() {
        return scanner.hasNext();
    }

    @Override
    protected String getNextImplementation() {
        if (hasNext())
            return scanner.next();
        return null;
    }
}
