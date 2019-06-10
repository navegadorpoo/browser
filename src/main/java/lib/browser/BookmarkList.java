package lib.browser;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.LinkedList;
import lib.database.repositories.BookmarkRepository;

public class BookmarkList implements Iterable {
    private LinkedList<Bookmark> bookmarks = new LinkedList<>();
    
    public void add(Bookmark bookmark) {
        bookmarks.add(bookmark);
    }
    
    public void add(String name, Location location ) {
        bookmarks.add(new Bookmark(name, location));
    }
    
    public void add(String name, String title, String href, LocalDateTime datetime) {
        bookmarks.add(new Bookmark(name, new Location(title, href, datetime)));
    }
    
    public void delete(int id) throws SQLException {
        bookmarks.removeIf(bookmark -> bookmark.getId() == id);
        BookmarkRepository.delete(id);
    }
    
    public void insert(Bookmark bookmark) throws SQLException {
        add(bookmark);
        BookmarkRepository.insert(bookmark);
    }

    @Override
    public Iterator iterator() {
        return bookmarks.iterator();
    }
}
