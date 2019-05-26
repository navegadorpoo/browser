package lib.browser;

import gui.WindowPanel;
import javax.swing.JPanel;
import lib.URLReader;
import lib.document.Document;
import lib.document.element.html.HTMLParser;
import lib.document.element.html.HTMLRenderer;

public class Window {
    private String title;
    private WindowPanel panel = new WindowPanel();
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
    
    public void open(String url) {
        URLReader urlReader = new URLReader(url);
        String html = urlReader.read();
        HTMLParser parser = new HTMLParser();
        parser.parse(html);
        document = parser.getDocument();
        location = new Location("titulo", url);
        render();
    }
    
    public void render() {
        HTMLRenderer renderer = new HTMLRenderer(panel.getPage());
        renderer.render(document);
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
        Browser.getInstance().changeActiveTabName(title);
    }
    
}
