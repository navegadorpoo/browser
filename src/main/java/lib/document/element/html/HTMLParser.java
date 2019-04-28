/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.document.element.html;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lib.document.Document;
import lib.document.element.Element;
import lib.document.node.Node;
import lib.interfaces.Parser;
import lib.util.Coalesce;

/**
 *
 * @author richard
 */
public class HTMLParser implements Parser {
    
    private static final String TAG_REGEX = "<\\s*(?<tag>[a-z1-6]+)\\s*(?<att>[^>]*)>(?<content>.*?)<\\s*/\\s*\\1\\s*>|<\\s*(?<monotag>[a-z1-6]+)\\s*(?<monoatt>[^>]*)/?>";
    private static final String ATTRIB_REGEX = "(?<attribute>[a-z]+)\\s*=\\s*\"(?<value>.*?)\"";
    
    private Document document;
    private Node lastParent;

    public HTMLParser() {
        document = new Document();
        lastParent = document;
    }

    @Override
    public void parse(String html) {
        if (html == null) {
            return;
        }
        
        Matcher m = Pattern.compile(HTMLParser.TAG_REGEX, Pattern.CASE_INSENSITIVE).matcher(html);
        
        while (m.find()) {
            String tag = Coalesce.get(m.group("tag"), m.group("monotag"));
            Node node = Document.createElement(tag);
            
            if (node == null) {
                continue;
            }
                 
            String att = Coalesce.get(m.group("att"), m.group("monoatt"));
            Matcher ma = Pattern.compile(HTMLParser.ATTRIB_REGEX, Pattern.CASE_INSENSITIVE)
                                .matcher(att);
            
            while (ma.find()) {
                ((Element)node).addAttribute(ma.group("attribute"), ma.group("value"));
            }
            
            lastParent.appendChild(node);
            Node tmpParent = lastParent;
            lastParent = node;
            parse(m.group("content"));
            lastParent = tmpParent;
        }
        if (html.matches("[^<>]+")) {
            lastParent.appendChild(Document.createCharacterNode("text", html));
        }
    }
    
    public Document getDocument() {
        return document;
    }
}
