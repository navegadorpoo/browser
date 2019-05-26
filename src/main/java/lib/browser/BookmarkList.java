package lib.browser;

import java.util.Iterator;
import java.util.LinkedList;

public class BookmarkList implements Iterable {
    private LinkedList<Bookmark> bookmarks = new LinkedList<>();
    
    public void add(Bookmark bookmark) {
        bookmarks.add(bookmark);
    }
    
    public void add(String name, Location location ) {
        bookmarks.add(new Bookmark(name, location));
    }
    
    public void add(String name, String title, String href ) {
        bookmarks.add(new Bookmark(name, new Location(title, href)));
    }

    @Override
    public Iterator iterator() {
        return bookmarks.iterator();
    }
}
