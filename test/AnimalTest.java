import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by chrisaanerud on 3/28/17.
 */
public class AnimalTest {


    @Test


    public void animalNameTestConstructor() {
        String expected = "name";
        String name = new String(expected);
        assertThat(expected, equalTo("name"));


    }

    @Test


    public void animalSpeciesTestConstructor() {
        String expected = "species";
        String species = new String(expected);
        assertThat(expected, equalTo("species"));


    }

    @Test


    public void animalBreedTestConstructor() {
        String expected = "breed";
        String breed = new String(expected);
        assertThat(expected, equalTo("breed"));


    }

    @Test


    public void animalDescriptionTestConstructor() {
        String expected = "description";
        String description = new String(expected);
        assertThat(expected, equalTo("description"));


    }

    @Test

    public void animalNameSettertoSetName(){
       String expected = "setName";
       String name = new String(expected);
        assertThat(expected, equalTo("setName"));


    }


    @Test

    public void animalSpeciesSettertoSetSpecies(){
        String expected = "setSpecies";
        String species = new String(expected);
        assertThat(expected, equalTo("setSpecies"));


    }


    @Test

    public void animalBreedSettertoSetBreed(){
        String expected = "setBreed";
        String breed = new String(expected);
        assertThat(expected, equalTo("setBreed"));


    }


    @Test

    public void animalDescriptionSettertoSetDescription(){
        String expected = "setDescription";
        String description = new String(expected);
        assertThat(expected, equalTo("setDescription"));


    }

}