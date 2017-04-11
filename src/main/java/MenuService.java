import java.util.ArrayList;
import java.util.Scanner;

public class MenuService {

    public static final int LIST_ANIMALS = 1;
    public static final int CREATE_ANIMAL = 2;
    public static final int VIEW_ANIMAL_DETAILS = 3;
    public static final int EDIT_ANIMAL = 4;
    public static final int DELETE_ANIMAL = 5;
    public static final int QUIT_PROGRAM = 6;


    private Scanner scanner;

    public MenuService(Scanner scanner) {
        this.scanner = scanner.useDelimiter("\n");
    }

    public int promptForMainMenu() {


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

            String badInput = scanner.nextLine();


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

            System.out.println((animal.getAnimalId()) + ")\t" + animal.getName() + "\t" + animal.getSpecies());

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

    public Animal editAnimal(Animal animal){

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

        return animal;


    }


   // public String sumOfNumbersFromSystemIn() {
    //    return null;
   // }

    public void sayHiChris() {
        System.out.println("Hi Chris");
    }


    public String sumOfNumbersFromSystemIn() {
        return null;
    }
}
