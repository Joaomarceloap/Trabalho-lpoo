package model.DAO;

import java.sql.*;

public class DBconfig {
    private static String url = "jdbc:postgresql://localhost:5432/DBmercadinho";
    private static String user = "postgres";
    private static String pass = "0808";
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, pass);
    }
}
