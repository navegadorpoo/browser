package lib.document.element.html;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import junit.framework.TestCase;
import lib.FileManager;
import lib.URLReader;
import lib.document.Document;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author richard
 */
public class HTMLParserTest extends TestCase {
    
    private String html;
    
    public HTMLParserTest() {
        URLReader url = new URLReader("https://pt.wikipedia.org/wiki/Wikip%C3%A9dia:P%C3%A1gina_principal");
        html = url.read();
        
//      FileManager fileManager = new FileManager(new File("src/test/resources/wiki.html"));
//      html = fileManager.prepare().readWholeFile();
    }

    @Test
    public void test_parse_html() {
        HTMLParser htmlParser = new HTMLParser();
        htmlParser.parse(html);
        Document document = htmlParser.getDocument();
        System.out.println(htmlParser.getDocument().getClass());
    }
}
