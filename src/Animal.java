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


    private String name;
    private String species;
    private String breed;
    private String description;

    public Animal(String name, String species, String breed, String description) {

        this.name = name;
        this.species = species;
        this.breed = breed;
        this.description = description;

    }

    public String getName() {

        return this.name;

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {

        return this.species;

    }

    public void setSpecies(String species) {

        this.species = species;
    }

    public String getBreed() {

        return this.breed;

    }

    public void setBreed(String breed) {

        this.breed = breed;
    }


    public String getDescription() {

        return this.description;
    }

    public void setDescription(String description) {

        this.description = description;

    }


}