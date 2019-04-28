package lib.document.element.html;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import lib.FileManager;
import lib.document.Document;
import org.junit.jupiter.api.Test;

/**
 *
 * @author richard
 */
public class HTMLParserTest {
    
    private String html;
    
    public HTMLParserTest() {
        FileManager fileManager = new FileManager(new File("src/test/resources/arquivo.html"));
        fileManager.prepare();
        String line;
        while ((line = fileManager.readLine()) != null) {
            html += line;
        }
        this.html = html;
    }

    @Test
    public void test_parse_html() {
        HTMLParser htmlParser = new HTMLParser();
        htmlParser.parse(html);
        Document document = htmlParser.getDocument();
        System.out.println(htmlParser.getDocument().getClass());
    }
}
