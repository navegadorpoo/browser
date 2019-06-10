package lib.document.element.html;

import junit.framework.TestCase;
import lib.document.Document;
import lib.document.element.Element;
import lib.document.node.character.Text;
import org.junit.jupiter.api.Test;

public class HTMLParserTest extends TestCase {
    
    private HTMLParser htmlParser;
    
    public HTMLParserTest() {
        htmlParser = new HTMLParser();
    }

    @Test
    public void testShouldParseOneTag() {
        htmlParser.parse("<html></html>");
        Document document = htmlParser.getDocument();
        assertTrue(document.getChild(0) instanceof HTMLHtmlElement);
    }
    
    @Test
    public void testShouldParseOneSelfClosingTagWithSlash() {
        htmlParser.parse("<input />");
        Document document = htmlParser.getDocument();
        assertTrue(document.getChild(0) instanceof HTMLInputElement);
    }
    
    @Test
    public void testShouldParseOneSelfClosingTagWithoutSlash() {
        htmlParser.parse("<input>");
        Document document = htmlParser.getDocument();
        assertTrue(document.getChild(0) instanceof HTMLInputElement);
    }
    
    @Test
    public void testShouldParseSiblingTags() {
        htmlParser.parse("<head></head><body></body>");
        Document document = htmlParser.getDocument();
        assertTrue(document.getChild(0) instanceof HTMLHeadElement);
        assertTrue(document.getChild(1) instanceof HTMLBodyElement);
    }
    
    @Test
    public void testShouldParseChildrenTags() {
        htmlParser.parse("<head><title></title></head>");
        Document document = htmlParser.getDocument();
        assertTrue(document.getChild(0) instanceof HTMLHeadElement);
        assertTrue(document.getChild(0).getChild(0) instanceof HTMLTitleElement);
    }
    
    @Test
    public void testShouldParseOneTextNode() {
        htmlParser.parse("<body>hello</body>");
        Document document = htmlParser.getDocument();
        assertTrue(document.getChild(0).getChild(0) instanceof Text);
        assertEquals(((Text)document.getChild(0).getChild(0)).getTextContent(), "hello");
    }
    
    @Test
    public void testShouldParseTextNodesBeforeChildTags() {
        htmlParser.parse("<body>hello<h1></h1></body>");
        Document document = htmlParser.getDocument();
        assertTrue(document.getChild(0).getChild(0) instanceof Text);
        assertEquals(((Text)document.getChild(0).getChild(0)).getTextContent(), "hello");
    }
    
    @Test
    public void testShouldParseTextNodesAfterChildTags() {
        htmlParser.parse("<body><h1></h1>world</body>");
        Document document = htmlParser.getDocument();
        assertTrue(document.getChild(0).getChild(1) instanceof Text);
        assertEquals(((Text)document.getChild(0).getChild(1)).getTextContent(), "world");
    }
    
    @Test
    public void testShouldParseAttributes() {
        htmlParser.parse("<div id=\"lorem\" class=\"ipsum\"></div>");
        Document document = htmlParser.getDocument();
        Element element = (Element) document.getChild(0);
        assertEquals(element.getAttribute("id"), "lorem");
        assertEquals(element.getAttribute("class"), "ipsum");
    }
}
