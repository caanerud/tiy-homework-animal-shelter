import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by chrisaanerud on 3/22/17.
 */



/**
 * Given a menu service
 * when a user is prompted for a main menu selection and they chose 3
 * then the value returned is 3
 *
 * Arrange
 * Act
 * Assert
 */
public class MenuServiceTest {


    ByteArrayOutputStream outputStream;
    ArrayList<Animal> animals;

    @Before
    public void before(){
        // setup output capturing
        this.outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(this.outputStream);
        System.setOut(printStream);


        animals = new ArrayList<>();
        animals.add(new Animal(
               ));
        animals.add(new Animal(
                )
        );
        animals.add(new Animal(

        ));
    }

    @Test

public void when1OnMainMenuThen1(){

        Scanner scanner = new Scanner("1");
        MenuService menuService = new MenuService(scanner);

    int select = menuService.promptForMainMenu();

    assertThat(select, equalTo(1));

}


@Test

    public void whenMainMenuThenMenuPrinted(){

    Scanner scanner = new Scanner("1");
    MenuService menu = new MenuService(scanner);

    // Act
    menu.promptForMainMenu();

    // Assert
    assertThat(this.outputStream.toString(), containsString("-- Main Menu --"));



}

    @Test
    /**
     * Given the main menu
     * When the user enters 2
     * Then 2 is returned
     */
    public void when2OnMainMenuThen2(){
        // Arrange
        Scanner scanner = new Scanner("2");
        MenuService menu = new MenuService(scanner);

        // Act
        int selection = menu.promptForMainMenu();

        // Assert
        assertThat(selection, equalTo(2));
    }


    @Test
    /**
     * Given the main menu
     * When the user enters 2
     * Then 2 is returned
     */
    public void when3OnMainMenuThen3(){
        // Arrange
        Scanner scanner = new Scanner("3");
        MenuService menu = new MenuService(scanner);

        // Act
        int selection = menu.promptForMainMenu();

        // Assert
        assertThat(selection, equalTo(3));
    }



    @Test

    public void when4OnMainMenuThen4(){
        // Arrange
        Scanner scanner = new Scanner("4");
        MenuService menu = new MenuService(scanner);

        // Act
        int selection = menu.promptForMainMenu();

        // Assert
        assertThat(selection, equalTo(4));
    }


    @Test

    public void when5OnMainMenuThen5(){
        // Arrange
        Scanner scanner = new Scanner("5");
        MenuService menu = new MenuService(scanner);

        // Act
        int selection = menu.promptForMainMenu();

        // Assert
        assertThat(selection, equalTo(5));
    }

    @Test

    public void when6OnMainMenuThen6(){
        // Arrange
        Scanner scanner = new Scanner("6");
        MenuService menu = new MenuService(scanner);

        // Act
        int selection = menu.promptForMainMenu();

        // Assert
        assertThat(selection, equalTo(6));
    }

}