package persistence;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseLocator {
    
    private static DatabaseLocator instance = new DatabaseLocator();

    public static DatabaseLocator getInstance() {
        return instance;
    }

    private DatabaseLocator() {
    }
    
    public java.sql.Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        java.sql.Connection conn = (java.sql.Connection) DriverManager.getConnection("jdbc:mysql://localhost/ifood", "root", "");
       
        return conn;
    }
}
