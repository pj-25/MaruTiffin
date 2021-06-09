import marutiffinDB.MarutiffinDB;

import java.io.IOException;
import java.sql.SQLException;

public class TestDB {
    public static void main(String[] s){
        try{
            MarutiffinDB marutiffinDB = new MarutiffinDB();
            System.out.println(marutiffinDB.getConnection());
            marutiffinDB.close();
        }catch (IOException|ClassNotFoundException| SQLException e){
            e.printStackTrace();
        }
    }
}
