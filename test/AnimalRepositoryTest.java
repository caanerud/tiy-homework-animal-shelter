import org.junit.Before;
import org.junit.Test;

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
    public void getAnimalTotal() throws Exception {
        assertThat(this.repository.getAnimalTotal(), equalTo(3));
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
