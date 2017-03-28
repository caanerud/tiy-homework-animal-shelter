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
}