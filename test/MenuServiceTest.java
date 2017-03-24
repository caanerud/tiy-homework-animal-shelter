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
 */
public class MenuServiceTest {

    @Test

    public void whenMenuSelectionIs3Then3(){


        //arrange

        String input = "3";
        Scanner scanner = new Scanner(input);
        MenuService service = new MenuService(scanner);

        //act
        int selection = service.promptForMainMenu();

        //assert

        assertThat(selection, equalTo(3));

    }


    @Test

    public void whenMenuSelectionIs2Then2(){

        String input = "2";

        Scanner scanner = new Scanner(input);



        //arrange

        MenuService service = new MenuService(scanner);

        //act
        int selection = service.promptForMainMenu();

        //assert

        assertThat(selection, equalTo(2));

    }


    @Test

    public void whenPromptedThenMenuDisplayed(){

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream outputStreamPrinter = new PrintStream(outputStream);
        System.setOut(outputStreamPrinter);
        String input = "2";

        Scanner scanner = new Scanner(input);



        //arrange

        MenuService service = new MenuService(scanner);

        //act
        service.promptForMainMenu();

        //assert

        assertThat(outputStreamPrinter.toString(), equalTo("Main Menu"));

    }



}
