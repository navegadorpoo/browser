package lib.document.element.html;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lib.document.Document;
import lib.document.element.Element;
import lib.document.node.Node;
import lib.interfaces.Parser;
import lib.util.Coalesce;

public class HTMLParser implements Parser {
    
    private static final String TAG_REGEX = "<\\s*(?<tag>[a-z1-6]+)\\s*(?<att>[^>]*)>(?<content>.*?)<\\s*/\\s*\\1\\s*>|<\\s*(?<monotag>[a-z1-6]+)\\s*(?<monoatt>[^>]*)/?>|(?<text>[^<>]++(?!>))";
    private static final String ATTRIB_REGEX = "(?<attribute>[a-z]+)\\s*=\\s*\"(?<value>.*?)\"";
    
    private Document document;

    public HTMLParser() {
        document = new Document();
    }

    @Override
    public void parse(String html) {
        parseHTML(html, document);
    }
    
    private void parseHTML(String html, Node parent) {
        if (html == null) {
            return;
        }
        
        Matcher m = Pattern.compile(HTMLParser.TAG_REGEX, Pattern.CASE_INSENSITIVE).matcher(html);
        
        while (m.find()) {
            Node node = createChildNode(m, parent);
            
            if (node == null) {
                continue;
            }
            
            parseHTML(m.group("content"), node);
        }
    }
    
    private Node createChildNode(Matcher m, Node parent) {
        String text = m.group("text");
        if (text != null) {
            createTextNode(parent, text);
            return null;
        }
        
        return createElementNode(m, parent);
    }
    
    private void createTextNode(Node parent, String text) {
        if (!text.matches("^\\s*$")) {
            parent.appendChild(Document.createCharacterNode("text", text));
        }
    }
    
    private Node createElementNode(Matcher m, Node parent) {
        String tag = Coalesce.get(m.group("tag"), m.group("monotag"));
        Node node = Document.createElement(tag);

        if (node == null) {
            return null;
        }

        insertAttributes(m, node);
        parent.appendChild(node);
        
        return node;
    }
    
    private void insertAttributes(Matcher m, Node node) {
        String att = Coalesce.get(m.group("att"), m.group("monoatt"));
        Matcher ma = Pattern.compile(HTMLParser.ATTRIB_REGEX, Pattern.CASE_INSENSITIVE)
                            .matcher(att);

        while (ma.find()) {
            ((Element)node).addAttribute(ma.group("attribute"), ma.group("value"));
        }
    }
    
    public Document getDocument() {
        return document;
    }
}
