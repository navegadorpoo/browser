package lib.database.repositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import lib.browser.Bookmark;
import lib.browser.Browser;
import lib.browser.Location;
import lib.database.Conn;

public class BookmarkRepository {

    private static final String TABLE_NAME = "bookmark";

    public static ArrayList<Bookmark> all() throws SQLException {
        ArrayList<Bookmark> bookmarks = new ArrayList<>();

        Connection conn = Conn.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(String.format(
            "SELECT * FROM %s WHERE `id_user` = %d", TABLE_NAME, Browser.getInstance().getUser().getId())
        );

        while (rs.next()) {
            bookmarks.add(new Bookmark(rs.getInt("id"), rs.getInt("id_user"), rs.getString("name"),
                    new Location(rs.getString("name"), rs.getString("url"), LocalDateTime.now())));
        }

        return bookmarks;
    }

    public static int insert(Bookmark bookmark) throws SQLException {
        Connection conn = Conn.getConnection();
        Statement st = conn.createStatement();

        st.executeUpdate(
            String.format("INSERT INTO `%s` (`id_user`, `name`, `url`) values (%s, '%s', '%s')",
            TABLE_NAME, bookmark.getIdUser(), bookmark.getName(), bookmark.getLocation().getUrl()),
            Statement.RETURN_GENERATED_KEYS
        );

        ResultSet rs = st.getGeneratedKeys();
        if (!rs.next()) {
            throw new SQLException("Problemas ao inserir item aos favoritos");
        }

        return rs.getInt(1);
    }

    public static void delete(int id) throws SQLException {
        Connection conn = Conn.getConnection();
        Statement st = conn.createStatement();
        st.executeUpdate(String.format("DELETE FROM `%s` WHERE `id` = %d", TABLE_NAME, id));
    }

}
