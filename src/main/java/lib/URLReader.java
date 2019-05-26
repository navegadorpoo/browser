package lib;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class URLReader {

    URL url;
    String html = "";

    public URLReader(String url) {
        try {
            this.url = new URL(UrlComplete.complete(url));
        } catch (MalformedURLException e) {
            //do something
        }
    }

    public String read() {
        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(url.openStream()
            ));
            String line;
            while ((line = reader.readLine()) != null) {
                html += line;
            }
            reader.close();
        } catch (IOException e) {
            return null;
        }

        return html;
    }
}
