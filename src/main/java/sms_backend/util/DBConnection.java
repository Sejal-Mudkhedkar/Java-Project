package sms_backend.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String url = "jdbc:mysql://localhost:3306/SMS";
    private static final String user = "root";
    private static final String password = System.getenv("MYSQL_PASSWORD");
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url, user, password);
    }
}
