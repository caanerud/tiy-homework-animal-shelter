import java.util.Scanner;

/**
 * Created by chrisaanerud on 3/20/17.
 */
public class Main {

    public static void main(String[] args){

        Animal animal = new Animal();
        Scanner scannerMain = new Scanner(System.in);

        MenuService menuService = new MenuService(scannerMain);

        menuService.promptForMainMenu();

        System.out.println(animal.getAnimalList());



        while(true){
            int input = menuService.promptForMainMenu();

            Animal animal1 = new Animal();

            if(input == 1){
                animal1.getAnimalList();

            }

            else {

                break;
            }
        }

    }
}
