import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by chrisaanerud on 4/3/17.
 */



public class AnimalRepositoryTest {

    AnimalRepository repository;
    String jdbcUrl = "jdbc:postgresql://localhost/animals_test";




    @Before
    public void before() throws Exception{
         this.repository = new AnimalRepository(jdbcUrl);
    }

    @Test
    public void animals() throws Exception {
        this.repository.animals();
    }


    @Test
    public void createAnimal() throws Exception {
        //create a new animal and write it to the animals table
        Animal animal1 = new Animal("a", "b","c", "d");
        int id1 = repository.createAnimal(animal1);

        //read back the just-written animal from the database
        ArrayList<Animal>animals = repository.readAnimalByID(id1);

        //we should have found the record that we just wrote
        assertThat(animals.isEmpty(), equalTo(false));

        //all of the fields of the newly read animal should match the fields of the original animal
        Animal animal2 = animals.get(0);
        assertThat(animal2.getName(), equalTo(animal1.getName()));
        assertThat(animal2.getSpecies(), equalTo(animal1.getSpecies()));
        assertThat(animal2.getBreed(), equalTo(animal1.getBreed()));
        assertThat(animal2.getDescription(), equalTo(animal1.getDescription()));
        assertThat(animal2.getAnimalId(), equalTo(animal1.getAnimalId()));


    }



    @Test
    public void deleteAnimal() throws Exception {
        for (Animal animal : repository.animals())
            repository.deleteAnimal(animal.getAnimalId());
        assertThat(repository.getAnimalTotal(), equalTo(0));
    }

    @Test
    public void updateAnimal() throws Exception {
        Animal animal = new Animal("Snart", "Marky Mark","Boar", "Wombat");
        int id1 = repository.createAnimal(animal);
        System.out.println("ID1:" + id1);

        animal.setName("Bob");
        animal.setAnimalId(id1);
        repository.updateAnimal(animal);
        //toDo: read back updated animal and prove that it's been updated
    }


    @Test
    public void createNewAnimalIncreasesByOne() throws Exception {
        int oldTotal = repository.getAnimalTotal();
        System.out.println("Before add:" + oldTotal);

        Animal animal = new Animal("Snart", "Marky Mark","Boar", "Wombat");
        int id1 = repository.createAnimal(animal);
        System.out.println("ID1:" + id1);

        int id2 = repository.createAnimal(animal);
        System.out.println("ID2:" + id2);
        assertThat(id2, equalTo(id1 + 1));

        int newTotal = repository.getAnimalTotal();
        System.out.println("After add:" + newTotal);

        assertThat(newTotal, equalTo(oldTotal +2));

    }
}
