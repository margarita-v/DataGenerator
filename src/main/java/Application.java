import generators.DateGenerator;
import generators.DoubleGenerator;
import generators.FileGenerator;
import generators.IntGenerator;

import java.io.File;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Application {

    /**
     * Name for a file which is used for task testing
     */
    private static final String FILE_NAME = System.getProperty("user.dir") + "/sample.txt";

    public static void main(String[] args) {

        List<Thread> threadList = new ArrayList<>();

        threadList.add(new Thread(() ->
                new FileGenerator(new File(FILE_NAME)).printAll()));

        threadList.add(new Thread(() ->
                new IntGenerator(1, 5).printAll()));

        threadList.add(new Thread(() -> new DateGenerator(
                LocalDate.of(2017, Month.NOVEMBER, 12),
                LocalDate.of(2017, Month.NOVEMBER, 23),
                DateGenerator.TypeOfDay.ALL)
                .printAll()));

        threadList.add(new Thread(() ->
                new IntGenerator(1, 10, 2).printAll()));

        threadList.add(new Thread(() ->
                new DoubleGenerator(1, 2).printAll()));

        threadList.add(new Thread(() ->
                new DoubleGenerator(1, 3, 0.5).printAll()));

        try {
            for (Thread thread : threadList) {
                thread.start();
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
