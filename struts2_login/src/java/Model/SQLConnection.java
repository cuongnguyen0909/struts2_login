package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLConnection {
    private static Connection connection;
    public void connect() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/manage_login";
        String dbUser = "root";
        String dbPassword = "";
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(url, dbUser, dbPassword);
    }
    public boolean checkLogin(String username, String password) throws SQLException,
            ClassNotFoundException {
        String sql = "SELECT * FROM user WHERE username = ? and password = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);
            statement.setString(2, password);
            try (ResultSet result = statement.executeQuery()) {
                while (result.next()) {
                    return true;
                }
                result.close();;
                statement.close();
                connection.close();
            }
        }
        return false;
    }
}
