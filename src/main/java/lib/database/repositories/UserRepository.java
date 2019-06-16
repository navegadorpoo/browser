package lib.database.repositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import lib.browser.User;
import lib.database.Conn;
import lib.util.MD5;

public class UserRepository {

    private static final String TABLE_NAME = "user";

    public static User consult(User user) throws SQLException {
        Connection conn = Conn.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(
            String.format("SELECT * FROM `%s` WHERE (`username` = '%s' OR `email` = '%s') AND `password` = '%s' LIMIT 1",
            TABLE_NAME, user.getUsername(), user.getEmail(), MD5.encode(user.getPassword()))
        );

        if (!rs.next()) {
            return null;
        }

        return new User(
            rs.getInt("id"),
            rs.getString("first_name"),
            rs.getString("last_name"),
            rs.getString("username"),
            rs.getString("email"),
            rs.getString("password")
        );
    }

    public static User consult(String username, String email, String password) throws SQLException {
        return consult(new User(0, null, null, username, email, password));
    }

    public static void insert(User user) throws SQLException {
        Connection conn = Conn.getConnection();
        Statement st = conn.createStatement();
        st.executeUpdate(String.format(
                "INSERT INTO `%s` (`first_name`, `last_name`, `username`, `email`, `password`) values ('%s', '%s', '%s', '%s', '$s')",
                TABLE_NAME, user.getFirstName(), user.getLastName(), user.getUsername(), user.getEmail(),
                user.getPassword()));
    }
}
