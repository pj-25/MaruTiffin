package marutiffinDB;

import databaseHandler.DatabaseHandler;

import java.io.IOException;
import java.sql.SQLException;

public class MarutiffinDB extends DatabaseHandler {

    public MarutiffinDB(String dbConfigFile) throws SQLException, IOException, ClassNotFoundException {
        super(dbConfigFile);
    }

    public MarutiffinDB() throws SQLException, IOException, ClassNotFoundException{
        super();
    }

    public void close(){
        try {
            connection.close();
        }catch (SQLException ignore){
        }
    }
}
