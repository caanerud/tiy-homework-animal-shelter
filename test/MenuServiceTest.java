import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

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

    @Test

public void when1OnMainMenuThen1(){

        Scanner scanner = new Scanner("1");
        MenuService menuService = new MenuService(scanner);

    int select = menuService.promptForMainMenu();

    assertThat(select, equalTo(1));

}


@Test

    public void whenMainMenuThenMenuPrinted(){




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

}