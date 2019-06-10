package lib.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import gui.components.interaction.Dialog;

public class URLReader {

    URL url;
    String html = "";

    public URLReader(String url) throws MalformedURLException {
        this.url = new URL(UrlComplete.complete(url));
    }

    public String read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            html += line;
        }
        reader.close();
        return html;
    }
}
