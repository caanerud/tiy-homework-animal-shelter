import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by chrisaanerud on 3/20/17.
 */
/*

This program is text-based and users interact with it using menus and textual prompts. You'll see all of these details below, but this is an example of what the main menu will look like:

-- Main Menu --

1) List animals
2) Create an animal
3) View animal details
4) Edit an animal
5) Delete an animal
6) Quit

Please choose an option:
When the user enters a value like 3 the program will know that the user wants to view an animal's details and then prompt them for which animal they want to view. If the user selects 2 or 4 the program will provide them with a series of prompts to collect data about the new animal.

Placing all of this logic into the Main class would quickly create a mess of spaghetti code. Instead, you should create a new class named MenuService. This class' responsibility is displaying menus, prompting the user for input, and returning the results. IE, it manages the menus.

For example, your MenuService might have a method named promptForMainMenu() that looks like this:

public int promptForMainMenuSelection() {
    System.out.println("\n-- Main Menu --\n" +
            "\n" +
            "1) List animals\n" +
            "2) Create an animal\n" +
            "3) View animal details\n" +
            "4) Edit an animal\n" +
            "5) Delete an animal\n" +
            "6) Quit\n");

    return waitForInt("Please choose an option:");
}
This method simply prints out the main menu text and then returns the value from another method named waitForInt().

The waitForInt() method might look like this:

/**
 * This method displays the provided prompt and then waits for a user to
 * provide input. The input must be a valid integer. If not, an error
 * message is displayed and the user is prompted to try again. If the input
 * is valid, then the value entered is returned.
 *
 * @param prompt The prompt displayed to the user.
 * @return The value entered by the user
 *
public int waitForInt(String prompt){
        // display the prompt to the user
        System.out.println(prompt);

        // check if the next input is an int.
        if(!scanner.hasNextInt()){
        // if the next input is not an int, read it as a string to show in an error message
        String badInput = scanner.next();

        // show an error message
        System.out.printf("'%s' is not a valid number. Please try again.\n", badInput);

        // recursively prompt the user again
        return waitForInt(prompt);
        } else {
        // return the int the user provided
        return scanner.nextInt();
        }

        }
        These two methods might look familiar as you've already created something similar for the previous Scanner exercise.

        This method prints out a prompt, such as "Please choose an option:". It then uses Scanner to read user input. This waits until the user has provided data and then checks to see if it was an integer. If so, that integer is returned. If not, an error message is shown and the method recurses.

        I suggest that you create methods for each action that can be performed on the menu. For example:

        int = promptForMainMenuSelection() - This might print the main menu, wait for user input, and return an integer indicating the user's choice.
        Animal = promptForAnimalData() - This might prompt the user for each field for an animal and then create and return a new instance of the Animal class using that data.
        There are many ways to accomplish this. But, it's generally an indicator you can do better if your methods become longer than ten or twenty lines.
        Somewhere in your application you will need to have an ArrayList of Animal instances. Give careful consideration to where you keep this. It might not make sense to have this in the MenuService. [callout-hint]

        [callout-hint] You could write methods that return an Animal or accept one as an argument. For example, why not write one method to collect information for a new animal, promptForNewAnimal(). This might prompt the user for the Animal's name, etc, and then actually construct and return an Animal. Maybe you could do something similar for editing an animal?


        */


public class MenuService {

    public static final int LIST_ANIMALS = 1;
    public static final int CREATE_ANIMAL = 2;
    public static final int VIEW_ANIMAL_DETAILS = 3;
    public static final int EDIT_ANIMAL = 4;
    public static final int DELETE_ANIMAL = 5;
    public static final int QUIT_PROGRAM = 6;




    private Scanner scanner;

    public MenuService(Scanner scanner){

        this.scanner = scanner;


    }

    public int promptForMainMenuSelection() {
        System.out.println("\n-- Main Menu --\n" +
                "\n" +
                "1) List animals\n" +
                "2) Create an animal\n" +
                "3) View animal details\n" +
                "4) Edit an animal\n" +
                "5) Delete an animal\n" +
                "6) Quit\n");

        return waitForInt("Please choose an option:");
    }

    public int waitForInt(String prompt){

        System.out.println(prompt);


        if(!scanner.hasNextInt()){

            String badInput = scanner.next();


            System.out.printf("'%s' is not a valid number. Please try again.\n", badInput);


            return waitForInt(prompt);
        } else {

            return scanner.nextInt();
        }

    }

    public String waitForString(String prompt, boolean needInput){

        System.out.println(prompt);

        String userInput = scanner.next();

        if(needInput == true && userInput.isEmpty()){

            System.out.println("This must be filled in with the correct information.");

            return waitForString(prompt, needInput);

        }else{

            return userInput;
        }







    }

    public void displayListOfAnimals(ArrayList<Animal> animalList) {

        System.out.println("\n-- List of Animals --\n");

        for(int x = 0; x < animalList.size(); x++){

            Animal animal = animalList.get(x);

            System.out.println((x + 1) + ")\t" + animal.getName() + "\t" + animal.getSpecies());

        }

    }

    public void displayAnimalDetails(Animal animal) {

        System.out.println("Name: \n" + animal.getName());

        System.out.println("Species: \n" + animal.getSpecies());

        System.out.println("Breed: \n" + animal.getBreed());

        System.out.println("Description: \n" + animal.getDescription());

    }

    public boolean deleteOrNot(String answer){

        String userInput = waitForString(answer, false);

        if(userInput.toLowerCase().equals("yes") || userInput.toLowerCase().equals("y")){

            return true;

        }else if(userInput.toLowerCase().equals("no") || userInput.toLowerCase().equals("n")) {

            return false;

        }else{

            System.out.println("Please enter a yes or a no (or y / n).");

            return deleteOrNot(answer);

        }


    }

    public void editAnimal(Animal animal){

        String input = "";

        input = waitForString(String.format("Name [%s]: ", animal.getName()), false);

        if(!input.isEmpty()){
            animal.setName(input);
        }

        input = waitForString(String.format("Species [%s]: ", animal.getSpecies()), false);

        if(!input.isEmpty()){
            animal.setSpecies(input);
        }

        input = waitForString(String.format("Breed [%s]: ", animal.getBreed()), false);

        if(!input.isEmpty()){
            animal.setBreed(input);
        }

        input = waitForString(String.format("Description [%s]: ", animal.getDescription()), false);

        if(!input.isEmpty()){
            animal.setDescription(input);
        }





    }


}
