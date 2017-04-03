import org.junit.Before;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by chrisaanerud on 4/2/17.
 */
public class MainTest {


    ByteArrayOutputStream outputStream;
    ArrayList<Animal> animals;
    Scanner scanner;


    @Before
    public void before() {
//
//        this.outputStream = new ByteArrayOutputStream();
//        PrintStream printStream = new PrintStream(this.outputStream);
//        System.setOut(printStream);

        scanner = new Scanner(System.in);




        animals = new ArrayList<>();
        animals.add(new Animal());
        animals.add(new Animal()
        );
        animals.add(new Animal());
    }


}
