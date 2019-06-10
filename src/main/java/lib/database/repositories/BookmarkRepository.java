package lib.database.repositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import lib.browser.Bookmark;
import lib.browser.Location;
import lib.database.Conn;

public class BookmarkRepository {

    private static final String TABLE_NAME = "bookmark";

    public static ArrayList<Bookmark> all() throws SQLException {
        ArrayList<Bookmark> bookmarks = new ArrayList<>();

        Connection conn = Conn.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(String.format("SELECT * FROM %s", TABLE_NAME));

        while (rs.next()) {
            bookmarks.add(new Bookmark(rs.getString("name"),
                    new Location(rs.getString("name"), rs.getString("url"), LocalDateTime.now())));
        }

        return bookmarks;
    }

    public static void insert(Bookmark bookmark) throws SQLException {
        Connection conn = Conn.getConnection();
        Statement st = conn.createStatement();
        st.executeUpdate(String.format("INSERT INTO `%s` (`id_user`, `name`, `url`) values (%s, '%s', '%s')",
                TABLE_NAME, bookmark.getIdUser(), bookmark.getName(), bookmark.getLocation().getUrl()));
    }

    public static void delete(int id) throws SQLException {
        Connection conn = Conn.getConnection();
        Statement st = conn.createStatement();
        st.executeUpdate(String.format("DELETE FROM `%s` WHERE `id` = %d", TABLE_NAME, id));
    }

}
