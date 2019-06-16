package lib.database.repositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import gui.components.interaction.Dialog;
import lib.browser.Browser;
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
        ResultSet rs = st.executeQuery(String.format(
            "SELECT * FROM `%s` WHERE `id_user` = %d", TABLE_NAME, Browser.getInstance().getUser().getId())
        );

        while (rs.next()) {
            history.add(new History(rs.getInt("id"), rs.getInt("id_user"), new Location(rs.getString("page_name"),
                    rs.getString("url"), DateFormat.getDateTimeFromString(rs.getString("date_access")))));
        }
        
        return history;
    }

    public static int insert(History history) throws SQLException {
        Connection conn = Conn.getConnection();
        Statement st = conn.createStatement();

        st.executeUpdate(
            String.format("INSERT INTO `%s` (`id_user`, `page_name`, `url`) values (%s, '%s', '%s')",
            TABLE_NAME, history.getIdUser(), history.getLocation().getTitle(), history.getLocation().getUrl()),
            Statement.RETURN_GENERATED_KEYS
        );

        ResultSet rs = st.getGeneratedKeys();
        if (!rs.next()) {
            throw new SQLException("Problemas ao inserir item ao histórico");
        }

        return rs.getInt(1);
    }

    public static void delete(int id) throws SQLException {
        Connection conn = Conn.getConnection();
        Statement st = conn.createStatement();
        st.executeUpdate(String.format("DELETE FROM `%s` WHERE `id` = %d", TABLE_NAME, id));
    }
}
