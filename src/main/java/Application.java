import generators.DateGenerator;
import generators.FileGenerator;

import java.io.File;
import java.time.LocalDate;
import java.time.Month;

public class Application {

    /**
     * Name for a file which is used for task testing
     */
    private static final String FILE_NAME = System.getProperty("user.dir") + "/sample.txt";

    public static void main(String[] args) {
        new FileGenerator(new File(FILE_NAME)).printAll();

        new DateGenerator(
                LocalDate.of(2017, Month.NOVEMBER, 12),
                LocalDate.of(2017, Month.NOVEMBER, 23),
                DateGenerator.TypeOfDay.FREE)
                .printAll();
    }
}
