import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by chrisaanerud on 4/7/17.
 */
public class AnimalTest {

    Animal animal1(){
        return new Animal("name1", "species1", "breed1", "description1");
    }

    Animal animal2(){
        return new Animal(2,"name2", "species2", "breed2", "description2");
    }
    
    @Test
    public void constructor1(){

        Animal pet = animal1();

        assertThat(animal1().getName(), equalTo("name1"));
        assertThat(animal1().getSpecies(), equalTo("species1"));
        assertThat(animal1().getBreed(), equalTo("breed1"));
        assertThat(animal1().getDescription(), equalTo("description1"));
    }

    @Test
    public void constructor2(){

        Animal pet = animal2();

        assertThat(animal2().getAnimalId(), equalTo(2));
        assertThat(animal2().getName(), equalTo("name2"));
        assertThat(animal2().getSpecies(), equalTo("species2"));
        assertThat(animal2().getBreed(), equalTo("breed2"));
        assertThat(animal2().getDescription(), equalTo("description2"));
    }

    @Test
    public void getName() throws Exception {

       assertThat(animal1().getName(), equalTo("name1"));
    }

    @Test
    public void setName() throws Exception {

        Animal pet = animal1();

        pet.setName("Fred");
        
        assertThat(pet.getName(), equalTo("Fred"));

    }

    @Test
    public void getSpecies() throws Exception {

        assertThat(animal1().getSpecies(), equalTo("species1"));
    }

    @Test
    public void setSpecies() throws Exception {

        Animal pet = animal1();

        pet.setSpecies("Fred");

        assertThat(pet.getSpecies(), equalTo("Fred"));

    }



    @Test
    public void getBreed() throws Exception {
        assertThat(animal1().getBreed(), equalTo("breed1"));
    }

    @Test
    public void setBreed() throws Exception {
        Animal pet = animal1();

        pet.setBreed("Fred");

        assertThat(pet.getBreed(), equalTo("Fred"));

    }

    @Test
    public void getDescription() throws Exception {
        assertThat(animal1().getDescription(), equalTo("description1"));
    }

    @Test
    public void setDescription() throws Exception {

        Animal pet = animal1();

        pet.setDescription("Fred");

        assertThat(pet.getDescription(), equalTo("Fred"));

    }

}