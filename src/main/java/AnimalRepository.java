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

        ResultSet result = statement.executeQuery("SELECT * FROM animals ORDER BY name ASC ");
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

    public int getAnimalTotal() throws Exception {
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery("SELECT COUNT (*) FROM animals");
        result.next();
        return result.getInt("count");
    }

    public int createAnimal(Animal animal) throws SQLException {

        PreparedStatement preparedStatement = conn.prepareStatement(
                "INSERT INTO animals(name, species, breed, description) VALUES(?, ?, ? ,?) RETURNING id ");



        preparedStatement.setString(1, animal.getName());
        preparedStatement.setString(2, animal.getSpecies());
        preparedStatement.setString(3, animal.getBreed());
        preparedStatement.setString(4, animal.getDescription());


        ResultSet result = preparedStatement.executeQuery();
        result.next();
        int id = result.getInt(1);
        animal.setAnimalId(id);
        return id;


    }

    public ArrayList<Animal> readAnimalByID(int animalId) throws SQLException {
        ArrayList<Animal> animalArrayList = new ArrayList<>();

        PreparedStatement preparedStatement = conn.prepareStatement(
                "SELECT * FROM animals WHERE id = ?");
        preparedStatement.setInt(1, animalId);

        ResultSet result = preparedStatement.executeQuery();

        while(result.next()){
            Animal ani = new Animal(
                    result.getInt("id"),
                    result.getString("name"),
                    result.getString("species"),
                    result.getString("breed"),
                    result.getString("description")
            );
            animalArrayList.add(ani);
        }
        return animalArrayList;

    }

    public void updateAnimal(Animal animal) throws SQLException{

        PreparedStatement preparedStatement = conn.prepareStatement(
                "UPDATE animals SET name = ?, species = ?, breed = ?, description = ? WHERE id = ?");

        preparedStatement.setString(1, animal.getName());
        preparedStatement.setString(2, animal.getSpecies());
        preparedStatement.setString(3, animal.getBreed());
        preparedStatement.setString(4, animal.getDescription());
        preparedStatement.setInt(5, animal.getAnimalId());


        preparedStatement.execute();

    }



    public void deleteAnimal(int id) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement(
                "DELETE FROM animals WHERE id = ?");

        preparedStatement.setInt(1, id);


        preparedStatement.execute();

    }


}


