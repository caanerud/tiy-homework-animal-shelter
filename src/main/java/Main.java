import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.*;

/**
 * Created by chrisaanerud on 3/20/17.
 */
public class Main {

    public static void main(String[] args) throws java.sql.SQLException, ClassNotFoundException {

        Class.forName("org.postgresql.Driver");
        String jdbcUrl = "jdbc:postgresql://localhost/animals_prod";
        AnimalRepository repository = new AnimalRepository(jdbcUrl);
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("[\n]");
        MenuService menuService = new MenuService(scanner);

        menuService.displayListOfAnimals(repository.animals());

        while (true) {

            int input = menuService.promptForMainMenu();


            if (input == menuService.LIST_ANIMALS) {

                menuService.displayListOfAnimals(repository.animals());

            } else if (input == menuService.CREATE_ANIMAL) {

                System.out.println("\n-- Create an Animal --\n");

                System.out.println("\nPlease fill in the following information:/n");

                String name = menuService.waitForString("Name of Animal:", true);

                String species = menuService.waitForString("Species of Animal:", true);

                String breed = menuService.waitForString("Breed of Animal (optional):", false);

                String description = menuService.waitForString("Description of Animal:", true);

                repository.createAnimal(new Animal(name, species, breed, description));

                System.out.println("\n" + "Hooray! Your animal has been successfully created.");

            } else if (input == menuService.VIEW_ANIMAL_DETAILS) {

                System.out.println("\n-- View an Animal --");

                int id = menuService.waitForInt("Please list the numeric ID of the animal you want to view:");
                ArrayList<Animal> animals = repository.readAnimalByID(id);

                if (animals.isEmpty()){
                    System.out.println("There is no animal with ID: " + id);
                }else{
                    menuService.displayAnimalDetails(animals.get(0));

                }


            } else if (input == menuService.EDIT_ANIMAL) {

                System.out.println("\n-- Edit an Animal --\n");

                int id = menuService.waitForInt("Please enter the numeric ID you would like to edit:");

                ArrayList<Animal> animals = repository.readAnimalByID(id);

                if (animals.isEmpty()){
                    System.out.println("There is no animal with ID: " + id);
                }else{
                    Animal animal = menuService.editAnimal(animals.get(0));
                    repository.updateAnimal(animal);

                }

            } else if (input == menuService.DELETE_ANIMAL)  {

                System.out.println("\n-- Delete an Animal --\n");

                int id = menuService.waitForInt("Please list the numeric ID of the animal that you wish to delete:");

                ArrayList<Animal> animals = repository.readAnimalByID(id);

                if (animals.isEmpty()){
                    System.out.println("There is no animal with ID: " + id);
                }else{
                    menuService.displayAnimalDetails(animals.get(0));

                    if(menuService.deleteOrNot("Are you sure that you want to delete this animal? y / n")){

                        repository.deleteAnimal(id);

                        System.out.println("Your animal has been successfully deleted.");
                    }

                }


            } else if (input == menuService.QUIT_PROGRAM) {

                System.out.println("Exiting program. Your information will be saved.");
                break;

            } else {
                System.out.println("Sorry, you made an incorrect choice. Please try again.");

            }


        }



    }

//    private static void listOfAnimals(){
//
//        animalList.add(new Animal("Fred", "dog", "Golden retriever", "beautiful"));
//        animalList.add(new Animal("Wilma", "cat", "Persian", "luxurious hair"));
//        animalList.add(new Animal("Juan", "pig", "Cumberland pig", "smells of elderberries"));
//        animalList.add(new Animal("Colleen", "hamster", "dwarf", "slightly cross-eyed"));
//        animalList.add(new Animal("Julius", "dog", "beagle", "one leg is a bit shorter than the others"));
//        animalList.add(new Animal("Vlad", "cat", "Maine coon", "long, gray hair and chubby face"));
//
//    }



}
