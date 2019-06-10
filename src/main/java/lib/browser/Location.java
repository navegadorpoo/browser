package lib.browser;

import java.time.LocalDateTime;
import lib.date.DateFormat;

public class Location {
    private String title;
    private String href;
    private LocalDateTime datetime;

    public Location(String title, String href, LocalDateTime datetime) {
        this.title = title;
        this.href = href;
        this.datetime = datetime;
    }
    
    public String getUrl() {
        return href;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getDateToShow() {
        return datetime.format(DateFormat.getBrazilianFormatter());
    }
}
