/**
 * Created by chrisaanerud on 4/3/17.
 */

import java.sql.*;

public class AnimalRepository {

    private Connection conn;

    public AnimalRepository(String jdbcUrl) throws SQLException {
        this.conn = DriverManager.getConnection(jdbcUrl);
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
