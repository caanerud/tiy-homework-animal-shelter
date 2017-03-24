import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.ArrayList;

/**
 * Created by chrisaanerud on 3/20/17.
 */

/*
Animals have these properties:

Name
Species
Breed
Description

 */
public class Animal {

   /* public ArrayList<String> getAnimalName() {
        ArrayList<String> animalName = new ArrayList<>();

        // Add names to the list using the add() method
        animalName.add("Barnabe");
        animalName.add("Prince");
        animalName.add("Walleye");
        animalName.add("Slick Willie");

        // Read the item at index 0 of the ArrayList using the get() method
        String name = animalName.get(0);
        System.out.println(name);
        return animalName;

 }  */

    ArrayList<String> animalList = new ArrayList<>();

    String name;
    String species;
    String breed;
    String description;
    private String animal;


    public Animal(){




       animalList.add("1. Roger           cat\n");
       animalList.add("2. Bert            dog\n");
       animalList.add("3. Ryan            hamster\n");
       animalList.add("4. Shaun           bat\n");


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<String> getAnimalList() {
        return animalList;
    }
}
