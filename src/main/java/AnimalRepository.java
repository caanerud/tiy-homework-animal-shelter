/**
 * Created by chrisaanerud on 4/3/17.
 */

//

import java.sql.*;
import java.util.ArrayList;

public class AnimalRepository {

    private Connection conn;
    private int animalCount;

    public AnimalRepository(String jdbcUrl) throws SQLException {
        this.conn = DriverManager.getConnection(jdbcUrl);
    }

    public ArrayList<Animal> animals() throws SQLException {

        ArrayList<Animal> animalArrayList = new ArrayList<>();

        Statement statement = conn.createStatement();

        ResultSet result = statement.executeQuery("SELECT * FROM LIST_ANIMALS ORDER BY id ASC ");
        while(result.next()){
            Animal animal = new Animal(
                    result.getInt("id"),
                    result.getString("name"),
                    result.getString("species"),
                    result.getString("breed"),
                    result.getString("description")
            );
            animalArrayList.add(animal);
        }
        return animalArrayList;


    }

    public int getAnimalTotal() {

        return getAnimalTotal();
    }

    public void createAnimal(Animal animal) throws SQLException {

        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO animal(name, species, breed, description " +
                "VALUES(?, ?, ? ,?) ");



        preparedStatement.setString(1, animal.getName());
        preparedStatement.setString(2, animal.getSpecies());
        preparedStatement.setString(3, animal.getBreed());
        preparedStatement.setString(4, animal.getDescription());


        preparedStatement.execute();


    }

    public class MenuService {
        private AnimalRepository animalRepository;

        public MenuService(AnimalRepository animalRepository){
            this.animalRepository = animalRepository;
        }
    }



    public void listAnimal(Animal animal){


    }




    public void readAnimalByID(Animal animal){


    }

    public void saveAnimalEdit(Animal animal){


    }

    public void saveNewAnimal(Animal animal){


    }

    public void deleteAnimal(Animal animal){


    }

}
