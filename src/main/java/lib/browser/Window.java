package lib.browser;

import gui.TabFactory;
import javax.swing.JPanel;
import lib.document.Document;

public class Window {
    private String title;
    private JPanel panel = TabFactory.makeTab();
    private Document document;
    private History history = new History();
    private BookmarkList bookmarks = new BookmarkList();
    private Location location;
    
    public Window(String title) {
        this.title = title;
        loadHistory();
        loadBookmarks();
    }
    
    public void loadHistory() {
        history.add(new Location("google", "http://www.google.com"));
    }
    
    public void loadBookmarks() {
        bookmarks.add(new Bookmark("Google", new Location("Google", "http://www.google.com")));
        bookmarks.add(new Bookmark("Facebook", new Location("Facebook", "http://www.facebook.com")));
        bookmarks.add(new Bookmark("Google", new Location("Google", "http://www.google.com")));
        bookmarks.add(new Bookmark("Facebook", new Location("Facebook", "http://www.facebook.com")));
        bookmarks.add(new Bookmark("Google", new Location("Google", "http://www.google.com")));
        bookmarks.add(new Bookmark("Facebook", new Location("Facebook", "http://www.facebook.com")));
        bookmarks.add(new Bookmark("Google", new Location("Google", "http://www.google.com")));
        bookmarks.add(new Bookmark("Facebook", new Location("Facebook", "http://www.facebook.com")));
        bookmarks.add(new Bookmark("Google", new Location("Google", "http://www.google.com")));
        bookmarks.add(new Bookmark("Facebook", new Location("Facebook", "http://www.facebook.com")));
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public History getHistory() {
        return history;
    }

    public void setHistory(History history) {
        this.history = history;
    }

    public BookmarkList getBookmarkList() {
        return bookmarks;
    }

    public void setBookmarkList(BookmarkList bookmarks) {
        this.bookmarks = bookmarks;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
    
    public JPanel getPanel() {
        return panel;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
}
