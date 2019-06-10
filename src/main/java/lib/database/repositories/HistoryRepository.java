package lib.database.repositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import gui.components.interaction.Dialog;
import lib.browser.History;
import lib.browser.Location;
import lib.database.Conn;
import lib.date.DateFormat;

public class HistoryRepository {

    private static final String TABLE_NAME = "history";

    public static ArrayList<History> all() throws SQLException {
        ArrayList<History> history = new ArrayList<>();

        Connection conn = Conn.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(String.format("SELECT * FROM `%s`", TABLE_NAME));

        while (rs.next()) {
            history.add(new History(rs.getInt("id"), rs.getInt("id_user"), new Location(rs.getString("page_name"),
                    rs.getString("url"), DateFormat.getDateTimeFromString(rs.getString("date_access")))));
        }
        
        return history;
    }

    public static void insert(History history) throws SQLException {
        Connection conn = Conn.getConnection();
        Statement st = conn.createStatement();
        st.executeUpdate(String.format("INSERT INTO `%s` (`id_user`, `page_name`, `url`) values (%s, '%s', '%s')",
                TABLE_NAME, history.getIdUser(), history.getLocation().getTitle(), history.getLocation().getUrl()));
    }

    public static void delete(int id) throws SQLException {
        Connection conn = Conn.getConnection();
        Statement st = conn.createStatement();
        st.executeUpdate(String.format("DELETE FROM `%s` WHERE `id` = %d", TABLE_NAME, id));
    }
}
