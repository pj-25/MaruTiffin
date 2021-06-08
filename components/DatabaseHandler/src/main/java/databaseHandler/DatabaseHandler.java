package databaseHandler;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public abstract class DatabaseHandler {

    protected Connection connection;
    protected Statement statement;
    protected PreparedStatement preparedStatement;

    private final static String DB_CONFIG_FILE = "config/dbConfig.properties";

    public static Connection createConnection(String configFile) throws IOException, ClassNotFoundException, SQLException {

        Properties dbConfig = new Properties();
        dbConfig.load(new FileReader(DB_CONFIG_FILE));

        String url = dbConfig.getProperty("URL");
        String driverName = dbConfig.getProperty("DRIVER_NAME");
        String userName = dbConfig.getProperty("USERNAME");
        String password = dbConfig.getProperty("PASSWORD");

        Class.forName(driverName);
        return DriverManager.getConnection(url, userName, password);
    }

    public static Connection createConnection() throws IOException, ClassNotFoundException, SQLException{
        return createConnection(DB_CONFIG_FILE);
    }

    public DatabaseHandler() throws SQLException, IOException, ClassNotFoundException {
            this(DB_CONFIG_FILE);
    }

    public DatabaseHandler(String dbConfigFile) throws SQLException, IOException, ClassNotFoundException {
        connection = createConnection(dbConfigFile);
        statement = connection.createStatement();
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public PreparedStatement getPreparedStatement() {
        return preparedStatement;
    }

    public void setPreparedStatement(PreparedStatement preparedStatement) {
        this.preparedStatement = preparedStatement;
    }

    public static String getDefaultDbConfigFile() {
        return DB_CONFIG_FILE;
    }
}
