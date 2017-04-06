import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import javax.swing.*;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

/**
 * Created by chrisaanerud on 3/22/17.
 */



/**
 * Given
 * when
 * then
 *
 * Arrange
 * Act
 * Assert
 */
public class MenuServiceTest {


    ByteArrayOutputStream outputStream;
    ArrayList<Animal> animals;
    Scanner scanner;
    MenuService menuService;

    @Before
    public void before(UIDefaults result) {
//
//        this.outputStream = new ByteArrayOutputStream();
//        PrintStream printStream = new PrintStream(this.outputStream);
//        System.setOut(printStream);

        scanner = new Scanner(System.in);
        menuService = new MenuService(scanner);



        animals = new ArrayList<>();
        animals.add(new Animal(result.getInt("animalid"), result.getString("name"), result.getString("species"), result.getString("breed"), result.getString("description")));
        animals.add(new Animal(result.getInt("animalid"), result.getString("name"), result.getString("species"), result.getString("breed"), result.getString("description"))
        );
        animals.add(new Animal(result.getInt("animalid"), result.getString("name"), result.getString("species"), result.getString("breed"), result.getString("description")));
    }

    @Test

    public void when1OnMainMenuThen1() {

       systemInMock.provideLines("1");

        int select = menuService.promptForMainMenu();

        assertThat(select, equalTo(1));

    }



    @Test

    public void when2OnMainMenuThen2() {
        // Arrange
       systemInMock.provideLines("2");
        // Act
        int selection = menuService.promptForMainMenu();

        // Assert
        assertThat(selection, equalTo(2));
    }


    @Test

    public void when3OnMainMenuThen3() {

        systemInMock.provideLines("3");
        int selection = menuService.promptForMainMenu();

        // Assert
        assertThat(selection, equalTo(3));
    }


    @Test

    public void when4OnMainMenuThen4() {
        // Act
        systemInMock.provideLines("4");
        int selection = menuService.promptForMainMenu();

        // Assert
        assertThat(selection, equalTo(4));
    }


    @Test

    public void when5OnMainMenuThen5() {
        // Arrange
        systemInMock.provideLines("5");
        // Act
        int selection = menuService.promptForMainMenu();

        // Assert
        assertThat(selection, equalTo(5));
    }

    @Test

    public void when6OnMainMenuThen6() {
        // Arrange
        systemInMock.provideLines("6");
        // Act
        int selection = menuService.promptForMainMenu();

        // Assert
        assertThat(selection, equalTo(6));
    }

    @Test

    public void whenMainMenuThenListAnimalsPrinted() {
        // Arrange
       systemInMock.provideLines("1");


        // Act
        menuService.promptForMainMenu();

        // Assert
        assertThat(systemOutRule.getLog(), containsString("1) List animals"));
    }

    @Test

    public void whenMainMenuThenCreateAnAnimalPrints() {
        // Arrange
        systemInMock.provideLines("2");

        // Act
        menuService.promptForMainMenu();

        // Assert
        assertThat(systemOutRule.getLog(), containsString("2) Create an animal"));
    }

    @Test

    public void whenMainMenuThenViewAnAnimalDetailsPrints() {
        // Arrange
       systemInMock.provideLines("3");

        // Act
        menuService.promptForMainMenu();

        // Assert
        assertThat(systemOutRule.getLog(), containsString("3) View animal details"));
    }

    @Test

    public void whenMainMenuThenEditAnAnimalPrints() {
        // Arrange
        systemInMock.provideLines("4");

        // Act
        menuService.promptForMainMenu();

        // Assert
        assertThat(systemOutRule.getLog(), containsString("4) Edit an animal"));
    }

    @Test


    public void whenMainMenuThenDeleteAnAnimalPrints() {
        // Arrange
       systemInMock.provideLines("5");

        // Act
        menuService.promptForMainMenu();

        // Assert
        assertThat(systemOutRule.getLog(), containsString("5) Delete an animal"));
    }

    @Test


    public void whenMainMenuThenQuitPrints() {
        // Arrange
       systemInMock.provideLines("6");

        // Act
        menuService.promptForMainMenu();

        // Assert
        assertThat(systemOutRule.getLog(), containsString("6) Quit"));
    }


    @Test

    public void whenStringInputToMainMenuThenRePrompt() {
        // Arrange
        systemInMock.provideLines("1");


        // Act
        int input = menuService.promptForMainMenu();

        // Assert
        assertThat(systemOutRule.getLog(), containsString("1"));
    }


    @Test


    public void whenOnMainMenuThenPromptForSelection() {
        // Arrange
       systemInMock.provideLines("2");

        // Act
        menuService.promptForMainMenu();

        // Assert
        assertThat(systemOutRule.getLog(), containsString("2"));
    }

    @Test

    public void whenUserInputIsWrongPrintMessage() {

        systemInMock.provideLines("1");
        String userInput = "";
        boolean needInput = false;
        String selection = menuService.waitForString("userInput", false);

        // Assert
        assertThat(selection, equalTo("1"));
    }

    @Test

    public void loginPromptAskForOption() {
        systemInMock.provideLines("1");
        menuService.promptForMainMenu();
        assertThat(systemOutRule.getLog(),containsString("option"));
    }

    @Test

    public void loginPromptChecksInputStringToEnsureValidNumberIsEntered() {
        systemInMock.provideLines("bird","2");
        menuService.promptForMainMenu();
        assertThat(systemOutRule.getLog(),containsString("is not a valid number. Please try again."));
    }

    @Test

    public void mainMenuPromptShouldAlwaysIncludeListAnimals() {
        systemInMock.provideLines("4","Y");
        menuService.promptForMainMenu();
        assertThat(systemOutRule.getLog(),containsString("List animals"));
    }

    @Test

    public void userSelectPromptWillNotAcceptNonIntegerValueAndReprompts(){
        systemInMock.provideLines("phone");
        menuService.waitForString("This must be filled in with the correct information.", true);
        assertThat(systemOutRule.getLog(),containsString("This must be filled in with the correct information."));

    }

    @Test

    public void listAnimalDisplaysAnimalInformationWithStringDefault(){
        menuService.displayListOfAnimals(animals);
        assertThat(systemOutRule.getLog(),containsString("null"));

    }

    @Test


    public void whenMainMenuPrintsThenItDisplaysListOfAnimals() {
        // Arrange
        systemInMock.provideLines("1");

        // Act
        menuService.displayListOfAnimals(animals);

        // Assert
        assertThat(systemOutRule.getLog(), containsString("-- List of Animals --"));
    }

    @Test


    public void whenMainMenuPrintsThenItDisplaysAnimalDetails() {
        // Arrange
        systemInMock.provideLines("1");

        // Act
        menuService.displayAnimalDetails(animals.get(1));

        // Assert
        assertThat(systemOutRule.getLog(), containsString("Name"));
    }

    @Test


    public void whenMainMenuPrintsThenChooseWhetherToDeleteOrNot() throws NoSuchElementException {
        // Arrange
        systemInMock.provideLines("yes");



        // Assert
        assertThat(menuService.deleteOrNot("yes"), equalTo(true));
    }

    @Test


    public void whenEditingAnimalStringInputIsEmpty() {
        // Arrange
        systemInMock.provideLines("1");

        // Act
        menuService.displayAnimalDetails(animals.get(1));

        // Assert
        assertThat(systemOutRule.getLog(), containsString(""));
    }




    //Input Demo

    @Rule
    public final TextFromStandardInputStream systemInMock
            = emptyStandardInputStream();

    @Test
    public void summarizesTwoNumbers() {
        Scanner scanner = new Scanner(System.in);
        MenuService menuService = new MenuService(scanner);
        systemInMock.provideLines("5", "6");
    //    assertThat(menuService.sumOfNumbersFromSystemIn(),equalTo(null));


    }





    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
    //Output Demo

    @Test
    /*
    Demo for console output
     */
    public void consoleOutputSaysHiChris(){
        Scanner scanner = new Scanner(System.in);
        MenuService menuService = new MenuService(scanner);
        menuService.sayHiChris();
        assertThat(systemOutRule.getLog(),equalTo("Hi Chris\n"));

    }






}