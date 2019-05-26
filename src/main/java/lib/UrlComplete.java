package lib;

public class UrlComplete {
    
    public static String complete(String url) {
        url = url.replaceFirst("/$", "") + "/";
        
        if (url.matches("^https?://")) {
            return url;
        }

        if (url.matches("^www\\.")) {
            return "http://" + url;
        }
        
        return "http://www." + url;
    }
}
