package lib.database;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import lib.io.FileManager;
import org.json.JSONObject;

public class Conn {
    
    private static Connection connection;
    
    private Conn() {}
    
    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            FileManager fileManager = new FileManager(new File("src/main/java/config/database.json"));
            JSONObject database = new JSONObject(fileManager.prepare().readWholeFile());
                    
            connection = DriverManager.getConnection(
                String.format("jdbc:%s://%s/%s",
                    database.getString("driver"),
                    database.getString("host"),
                    database.getString("database")
                ),
                database.getString("username"),
                database.getString("password")
            );
        }
        return connection;
    }
}
