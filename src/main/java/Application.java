import generators.FileGenerator;

import java.io.File;

public class Application {

    /**
     * Name for a file which is used for task testing
     */
    private static final String FILE_NAME = System.getProperty("user.dir") + "/sample.txt";

    public static void main(String[] args) {
        FileGenerator fileGenerator = new FileGenerator(new File(FILE_NAME));
        while (fileGenerator.hasNext())
            System.out.println(fileGenerator.getNext());
    }
}
