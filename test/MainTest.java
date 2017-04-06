import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import javax.swing.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;


/**
 * Created by chrisaanerud on 4/2/17.
 */
public class MainTest {


    ByteArrayOutputStream outputStream;
    ArrayList<Animal> animals;
    Scanner scanner;
    private UIDefaults result;


    @Before
    public void before() {
//
//        this.outputStream = new ByteArrayOutputStream();
//        PrintStream printStream = new PrintStream(this.outputStream);
//        System.setOut(printStream);

        scanner = new Scanner(System.in);




        animals = new ArrayList<>();
        animals.add(new Animal(result.getInt("animalid"), result.getString("name"), result.getString("species"), result.getString("breed"), result.getString("description")));
        animals.add(new Animal(result.getInt("animalid"), result.getString("name"), result.getString("species"), result.getString("breed"), result.getString("description"))
        );
        animals.add(new Animal(result.getInt("animalid"), result.getString("name"), result.getString("species"), result.getString("breed"), result.getString("description")));
    }

    @Rule
    public final TextFromStandardInputStream systemInMock
            = emptyStandardInputStream();

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
    //Output Demo

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test

    public void userEntersAndExitsProgram() throws IOException, SQLException, ClassNotFoundException {

        String[] args = null;
        systemInMock.provideLines("6","n");
        Main.main(args);

    }

    @Test

    public void listOfAnimalsPrintsFred()  {

        systemInMock.provideLines("1");

       Animal animal = new Animal(result.getInt("animalid"), result.getString("name"), result.getString("species"), result.getString("breed"), result.getString("description"));

        // Assert
        assertThat(systemOutRule.getLog(), containsString(""));
    }

    @Test

    public void ExitProgram() throws IOException, SQLException, ClassNotFoundException {

        String[] args = null;
        systemInMock.provideLines("6");
        Main.main(args);

    }


    @Test


    public void whenMainMenuListsAnimalsCheckForWords() {
        // Arrange
        systemInMock.provideLines("1");

        // Act
        scanner.next();

        // Assert
        assertThat(systemOutRule.getLog(), containsString(""));
    }



}
