import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by chrisaanerud on 3/20/17.
 */
public class Main {


    private static ArrayList<Animal> animalList = new ArrayList<>();

    public static void main(String[] args) throws NullPointerException{

        Scanner scanner = new Scanner(System.in);

        scanner.useDelimiter("[\n]");

        listOfAnimals();

        MenuService menuService = new MenuService(scanner);




        while (true) {

            int input = menuService.promptForMainMenu();


            if (input == menuService.LIST_ANIMALS) {

                menuService.displayListOfAnimals(animalList);

            } else if (input == menuService.CREATE_ANIMAL) {

                System.out.println("\n-- Create an Animal --\n");

                System.out.println("\nPlease fill in the following information:/n");

                String name = menuService.waitForString("Name of Animal:", true);

                String species = menuService.waitForString("Species of Animal:", true);

                String breed = menuService.waitForString("Breed of Animal (optional):", false);

                String description = menuService.waitForString("Description of Animal:", true);

                animalList.add(new Animal(name, species, breed, description));

                System.out.println("\n" + "Hooray! Your animal has been successfully created.");

            } else if (input == menuService.VIEW_ANIMAL_DETAILS) {

                System.out.println("\n-- View an Animal --");

                Animal animal = animalList.get(menuService.waitForInt("Please list the numeric ID of the animal you want to view:")-1);

                menuService.displayAnimalDetails(animal);


            } else if (input == menuService.EDIT_ANIMAL) {

                System.out.println("\n-- Edit an Animal --\n");

                int index = menuService.waitForInt("Please enter the numeric ID you would like to edit:")-1;

                Animal animal = animalList.get(index);

                menuService.editAnimal(animal);






            } else if (input == menuService.DELETE_ANIMAL)  {

                //NEED TO THROW AN EXCEPTION IF USER CHOOSES AN INVAlID NUMBER
                //if animalList.size() < index
                //return waitForInt (prompt: "Please pick an existing ID"

                System.out.println("\n-- Delete an Animal --\n");

                int chooseToDelete = menuService.waitForInt("Please list the numeric ID of the animal that you wish to delete:")-1;

                Animal animal = animalList.get(chooseToDelete);

                menuService.displayAnimalDetails(animal);

                if(menuService.deleteOrNot("Are you sure that you want to delete this animal? y / n")){

                    animalList.remove(chooseToDelete);

                    System.out.println("Your animal has been successfully deleted.");


                }


            } else if (input == menuService.QUIT_PROGRAM) {

                System.out.println("Exiting program. Your information will not be saved.");
                break;

            } else {
                System.out.println("Sorry, you made an incorrect choice. Please try again.");

            }


        }



    }

    private static void listOfAnimals(){

        animalList.add(new Animal("Fred", "dog", "Golden retriever", "beautiful"));
        animalList.add(new Animal("Wilma", "cat", "Persian", "luxurious hair"));
        animalList.add(new Animal("Juan", "pig", "Cumberland pig", "smells of elderberries"));
        animalList.add(new Animal("Colleen", "hamster", "dwarf", "slightly cross-eyed"));
        animalList.add(new Animal("Julius", "dog", "beagle", "one leg is a bit shorter than the others"));
        animalList.add(new Animal("Vlad", "cat", "Maine coon", "long, gray hair and chubby face"));

    }



}
