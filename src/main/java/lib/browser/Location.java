package lib.browser;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Location {
    private String title;
    private String href;
    private Timestamp timestamp = new Timestamp(System.currentTimeMillis());

    public Location(String title, String href) {
        this.title = title;
        this.href = href;
    }
    
    public String getUrl() {
        return href;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/YYYY H:m:i");
        return sdf.format(timestamp);
    }
}
