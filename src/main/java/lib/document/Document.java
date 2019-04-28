package lib.document;

import lib.document.element.html.HTMLBodyElement;
import lib.document.element.html.HTMLHeadElement;
import lib.document.element.html.HTMLHtmlElement;
import lib.document.element.html.HTMLMetaElement;
import lib.document.element.html.HTMLOptionElement;
import lib.document.element.html.HTMLParagraphElement;
import lib.document.element.html.HTMLSelectElement;
import lib.document.element.html.HTMLTitleElement;
import lib.document.node.Node;
import lib.document.node.NodeType;
import lib.document.node.character.Comment;
import lib.document.node.character.Text;

public class Document extends Node {

    public Document() {
        super(NodeType.DOCUMENT);
    }
    
    public static Node createElement(String tag) {
        tag = tag.toLowerCase();
        
        switch (tag) {
            case "html":   return new HTMLHtmlElement();
            case "head":   return new HTMLHeadElement();
            case "body":   return new HTMLBodyElement();
            case "title":  return new HTMLTitleElement();
            case "meta":   return new HTMLMetaElement();
            case "p":      return new HTMLParagraphElement();
            case "select": return new HTMLSelectElement();
            case "option": return new HTMLOptionElement();
            default:       return null;
        }
    }
    
        
    public static Node createCharacterNode(String type, String text) {
        switch (type) {
            case "comment": return new Comment(text);
            case "text":    return new Text(text);
            default:        return null;
        }
    }
}
