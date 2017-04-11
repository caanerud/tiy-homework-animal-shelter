import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import javax.swing.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static java.awt.SystemColor.menu;
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
    ArrayList<Animal> animals (){
        ArrayList<Animal> list = new ArrayList<Animal>();
        list.add(animal1());
        list.add(animal2());
        return list;
    }
    Animal animal1(){
        return new Animal("name1", "species1", "breed1", "description1");
    }

    Animal animal2(){
        return new Animal(2,"name2", "species2", "breed2", "description2");
    }




//    public void animalTesting(UIDefaults result) {
//
//        animals = new ArrayList<>();
//        animals.add(new Animal(result.getInt("animalId"), result.getString("name"), result.getString("species"), result.getString("breed"), result.getString("description")));
//        animals.add(new Animal(result.getInt("animalId"), result.getString("name"), result.getString("species"), result.getString("breed"), result.getString("description"))
//        );
//        animals.add(new Animal(result.getInt("animalId"), result.getString("name"), result.getString("species"), result.getString("breed"), result.getString("description")));
//    }


    public void before(){
        this.outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(this.outputStream);
        System.setOut(printStream);

    }

    @Test
    public void promptForMainMenu() throws Exception {
        // Arrange

        Scanner scanner = new Scanner("1");
        MenuService menu = new MenuService(scanner);

        // Act
        int selection = menu.promptForMainMenu();

        // Assert
        assertThat(selection, equalTo(1));
    }

    @Test
    public void waitForInt() throws Exception {

        Scanner scanner = new Scanner("2");
        MenuService menu = new MenuService(scanner);

        // Act
        int selection = menu.waitForInt("2");

        // Assert
        assertThat(selection, equalTo(2));

    }

    @Test
    public void waitForString() throws Exception {

        Scanner scanner = new Scanner("face");
        MenuService menu = new MenuService(scanner);

        // Act
        String selection = menu.waitForString("face", true);

        // Assert
        assertThat(selection, equalTo("face"));

    }

    @Test
    public void displayListOfAnimals() throws Exception {


        Scanner scanner = new Scanner("1");
        MenuService menu = new MenuService(scanner);
        ArrayList<Animal> animalList = new ArrayList<>();

        // Act
        menu.displayListOfAnimals(animalList);

        // Assert
        assertThat(systemOutRule.getLog(), containsString("Animals"));


    }

    @Test
    public void displayAnimalDetails() throws Exception {
        Scanner scanner = new Scanner("Species:");
        scanner.useDelimiter("[\n]");
        MenuService menu = new MenuService(scanner);

        ArrayList<Animal> animals = new ArrayList<>();

        // Act
        Animal animal = new Animal("fred", "bob", "sally", "goober" );
        menu.displayAnimalDetails(animal);

        // Assert


        assertThat(systemOutRule.getLog(),containsString("Species:"));
    }

    @Test
    public void deleteOrNot() throws Exception {
        Scanner scanner = new Scanner("y");
        scanner.useDelimiter("[\n]");
        MenuService menu = new MenuService(scanner);



        // Act
        menu.deleteOrNot("y");

        // Assert


        assertThat(systemOutRule.getLog(),containsString("y"));
    }

    @Test
    public void editAnimal() throws Exception {
        Scanner scanner = new Scanner("a\n" + "b\n" + "c\n" + "d\n");
        scanner.useDelimiter("[\n]");
        MenuService menu = new MenuService(scanner);

        Animal animal = new Animal("fred", "bob", "sally", "goober" );

        // Act
        menu.editAnimal(animal);

        // Assert


        assertThat(systemOutRule.getLog(),containsString(""));
    }

    @Test

    public void when1OnMainMenuThen1() {

        Scanner scanner = new Scanner("1");
        MenuService menu = new MenuService(scanner);

        // Act
        int selection = menu.promptForMainMenu();

        // Assert
        assertThat(selection, equalTo(1));

    }



    @Test

    public void when2OnMainMenuThen2() {
        // Arrange
        Scanner scanner = new Scanner("2");
        MenuService menu = new MenuService(scanner);

        // Act
        int selection = menu.promptForMainMenu();

        // Assert
        assertThat(selection, equalTo(2));
    }


    @Test

    public void when3OnMainMenuThen3() {

        Scanner scanner = new Scanner("3");
        MenuService menu = new MenuService(scanner);
        int selection = menu.promptForMainMenu();

        // Assert
        assertThat(selection, equalTo(3));
    }


    @Test

    public void when4OnMainMenuThen4() {
        // Act
        Scanner scanner = new Scanner("4");
        MenuService menu = new MenuService(scanner);
        int selection = menu.promptForMainMenu();

        // Assert
        assertThat(selection, equalTo(4));
    }


    @Test

    public void when5OnMainMenuThen5() {
        // Arrange
        Scanner scanner = new Scanner("5");
        MenuService menu = new MenuService(scanner);
        // Act
        int selection = menu.promptForMainMenu();

        // Assert
        assertThat(selection, equalTo(5));
    }

    @Test

    public void when6OnMainMenuThen6() {
        // Arrange
        Scanner scanner = new Scanner("6");
        MenuService menu = new MenuService(scanner);
        // Act
        int selection = menu.promptForMainMenu();

        // Assert
        assertThat(selection, equalTo(6));
    }

    @Test

    public void whenMainMenuThenListAnimalsPrinted() {
        // Arrange
        Scanner scanner = new Scanner("1");
        MenuService menu = new MenuService(scanner);


        // Act
        menu.promptForMainMenu();

        // Assert
        assertThat(systemOutRule.getLog(), containsString("1) List animals"));
    }

    @Test

    public void whenMainMenuThenCreateAnAnimalPrints() {
        // Arrange
        Scanner scanner = new Scanner("2");
        MenuService menu = new MenuService(scanner);

        // Act
        menu.promptForMainMenu();

        // Assert
        assertThat(systemOutRule.getLog(), containsString("2) Create an animal"));
    }

    @Test

    public void whenMainMenuThenViewAnAnimalDetailsPrints() {
        // Arrange
        Scanner scanner = new Scanner("3");
        MenuService menu = new MenuService(scanner);

        // Act
        menu.promptForMainMenu();

        // Assert
        assertThat(systemOutRule.getLog(), containsString("3) View animal details"));
    }

    @Test

    public void whenMainMenuThenEditAnAnimalPrints() {
        // Arrange
        Scanner scanner = new Scanner("4");
        MenuService menu = new MenuService(scanner);

        // Act
        menu.promptForMainMenu();

        // Assert
        assertThat(systemOutRule.getLog(), containsString("4) Edit an animal"));
    }

    @Test


    public void whenMainMenuThenDeleteAnAnimalPrints() {
        // Arrange
        Scanner scanner = new Scanner("5");
        MenuService menu = new MenuService(scanner);

        // Act
        menu.promptForMainMenu();

        // Assert
        assertThat(systemOutRule.getLog(), containsString("5) Delete an animal"));
    }

    @Test


    public void whenMainMenuThenQuitPrints() {
        // Arrange
        Scanner scanner = new Scanner("6");
        MenuService menu = new MenuService(scanner);

        // Act
        menu.promptForMainMenu();

        // Assert
        assertThat(systemOutRule.getLog(), containsString("6) Quit"));
    }


    @Test

    public void whenStringInputToMainMenuThenRePrompt() {
        // Arrange
        Scanner scanner = new Scanner("1");
        MenuService menu = new MenuService(scanner);


        // Act
        int input = menu.promptForMainMenu();

        // Assert
        assertThat(systemOutRule.getLog(), containsString("1"));
    }


    @Test


    public void whenOnMainMenuThenPromptForSelection() {
        // Arrange
        Scanner scanner = new Scanner("2");
        MenuService menu = new MenuService(scanner);

        // Act
        menu.promptForMainMenu();

        // Assert
        assertThat(systemOutRule.getLog(), containsString("2"));
    }

    @Test

    public void whenUserInputIsWrongPrintMessage() {

        Scanner scanner = new Scanner("1");
        MenuService menu = new MenuService(scanner);
        String userInput = "";
        boolean needInput = false;
        String selection = menu.waitForString("userInput", false);

        // Assert
        assertThat(selection, equalTo("1"));
    }

    @Test

    public void loginPromptAskForOption() {
        Scanner scanner = new Scanner("1");
        MenuService menu = new MenuService(scanner);
        menu.promptForMainMenu();
        assertThat(systemOutRule.getLog(),containsString("option"));
    }

    @Test

    public void loginPromptChecksInputStringToEnsureValidNumberIsEntered() {
        Scanner scanner = new Scanner("cat\ndog\n4");
        scanner.useDelimiter("[\n]");
        MenuService menu = new MenuService(scanner);

        menu.promptForMainMenu();
        assertThat(systemOutRule.getLog(),containsString("is not a valid number. Please try again."));
    }

    @Test

    public void mainMenuPromptShouldAlwaysIncludeListAnimals() {
        Scanner scanner = new Scanner("-- List of Animals --");
        scanner.useDelimiter("[\n]");
        MenuService menu = new MenuService(scanner);
        ArrayList<Animal> animals = new ArrayList<>();

        // Act
        menu.displayListOfAnimals(animals);

        // Assert


        assertThat(systemOutRule.getLog(),containsString("\n-- List of Animals --\n\n"));
    }

    @Test

    public void userSelectPromptWillNotAcceptNonIntegerValueAndReprompts(){
        systemInMock.provideLines("phone");

/*
The TextFromStandardInputStream rule replaces System.in with another InputStream, which provides an arbitrary text. The original
System.in is restored after the test.
public void MyTest { @Rule public final TextFromStandardInputStream systemInMock = emptyStandardInputStream(); @Test public void
readTextFromStandardInputStream() { systemInMock.provideLines("foo", "bar"); Scanner scanner = new Scanner(System.in); scanner.nextLine();
 assertEquals("bar", scanner.nextLine()); } }
 */
        Scanner scanner = new Scanner(System.in);
        MenuService menuService = new MenuService(scanner);
      menuService.waitForString("This must be filled in with the correct information.", true);
        assertThat(systemOutRule.getLog(),containsString("This must be filled in with the correct information."));

    }

    @Test

    public void listAnimalDisplaysAnimalInformationWithStringDefault(){
        Scanner scanner = new Scanner(System.in);
        MenuService menuService = new MenuService(scanner);
       menuService.displayListOfAnimals(animals());
        assertThat(systemOutRule.getLog(),containsString("-- List of Animals --"));

    }

    @Test


    public void whenMainMenuPrintsThenItDisplaysListOfAnimals() throws Exception {
        // Arrange
        systemInMock.provideLines("1");
        Scanner scanner = new Scanner(System.in);
        MenuService menuService = new MenuService(scanner);

        // Act
        menuService.displayListOfAnimals(animals());

        // Assert
        assertThat(systemOutRule.getLog(), containsString("-- List of Animals --"));
    }

    @Test


    public void whenMainMenuPrintsThenItDisplaysAnimalDetails() throws NullPointerException {
        // Arrange
        Scanner scanner = new Scanner("Breed:");
        scanner.useDelimiter("[\n]");
        MenuService menu = new MenuService(scanner);

        ArrayList<Animal> animals = new ArrayList<>();

        // Act
        Animal animal = new Animal("fred", "bob", "sally", "goober" );
        menu.displayAnimalDetails(animal);

        // Assert


        assertThat(systemOutRule.getLog(),containsString("Breed:"));
    }

    @Test


    public void whenMainMenuPrintsThenChooseWhetherToDeleteOrNot() throws NoSuchElementException {
        // Arrange
        systemInMock.provideLines("yes");



        // Assert
        Scanner scanner = new Scanner(System.in);
        MenuService menuService = new MenuService(scanner);
        assertThat(menuService.deleteOrNot("yes"), equalTo(true));
    }

    @Test


    public void whenEditingAnimalStringInputIsEmpty() {
        // Arrange
        Scanner scanner = new Scanner("");
        MenuService menu = new MenuService(scanner);
        Animal animal = new Animal(1, "a", "b", "c", "d");

        // Act
        menu.displayAnimalDetails(animal);

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
        assertThat(menuService.sumOfNumbersFromSystemIn(),equalTo(null));


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