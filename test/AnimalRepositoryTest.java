import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by chrisaanerud on 4/3/17.
 */



public class AnimalRepositoryTest {




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
