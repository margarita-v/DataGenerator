import generators.DateGenerator;
import generators.FileGenerator;

import java.io.File;
import java.util.Date;

public class Application {

    /**
     * Name for a file which is used for task testing
     */
    private static final String FILE_NAME = System.getProperty("user.dir") + "/sample.txt";

    public static void main(String[] args) {
        FileGenerator fileGenerator = new FileGenerator(new File(FILE_NAME));
        while (fileGenerator.hasNext())
            System.out.println(fileGenerator.getNext());

        System.out.println();

        DateGenerator dateGenerator = new DateGenerator(
                new Date(117, 11, 12),
                new Date(117, 11, 23),
                DateGenerator.TypeOfDay.WORKING);
        while (dateGenerator.hasNext())
            System.out.println(dateGenerator.getNext().toString());
    }
}
