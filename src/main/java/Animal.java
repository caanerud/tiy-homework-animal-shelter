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

    private String name;
    private String species;
    private String breed;
    private String description;
    private int animalId;

    public Animal(String name, String species, String breed, String description) {
        this.animalId = -1;
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.description = description;

    }

    public Animal(int animalId, String name, String species, String breed, String description) {

        this.animalId = animalId;
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


    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }
}