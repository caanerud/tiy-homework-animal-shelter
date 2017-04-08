import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by chrisaanerud on 4/3/17.
 */



public class AnimalRepositoryTest {

    AnimalRepository repository;
    String jdbcUrl = "jdbc:postgresql://localhost/animals"; //todo: change to use test database rather than production


    @Before
    public void before() throws Exception{
         this.repository = new AnimalRepository(jdbcUrl);
    }

    @Test
    public void animals() throws Exception {
    this.repository.animals();
    }

    @Test
    public void getAnimalTotal() throws Exception {

    }

    @Test
    public void createAnimal() throws Exception {

    }

    @Test
    public void listAnimal() throws Exception {

    }

    @Test
    public void readAnimalByID() throws Exception {

    }

    @Test
    public void saveAnimalEdit() throws Exception {

    }

    @Test
    public void saveNewAnimal() throws Exception {

    }

    @Test
    public void deleteAnimal() throws Exception {

    }


    @Test
    public void createNewAnimalIncreasesByOne() throws Exception {

        Animal animal = new Animal("Snart", "Marky Mark","Boar", "Wombat");
        AnimalRepository repository = null;
        System.out.println("Before add:" + repository.getAnimalTotal());

        repository.createAnimal(animal);

        int newTotal = repository.getAnimalTotal();
        System.out.println("After add:" + newTotal);

        assertThat(newTotal, equalTo(2));

    }
}
