package lib.document;

import lib.document.element.html.*;
import lib.document.node.*;
import lib.document.node.character.*;

public class Document extends Node {

    public Document() {
        super(NodeType.DOCUMENT);
    }
    
    public static Node createElement(String tag) {
        tag = tag.toLowerCase();
        
        switch (tag) {
            case "html":     return new HTMLHtmlElement();
            case "head":     return new HTMLHeadElement();
            case "body":     return new HTMLBodyElement();
            case "title":    return new HTMLTitleElement();
            case "meta":     return new HTMLMetaElement();
            case "p":        return new HTMLParagraphElement();
            case "select":   return new HTMLSelectElement();
            case "option":   return new HTMLOptionElement();
            case "a":        return new HTMLAnchorElement();
            case "b":        return new HTMLBoldElement();
            case "br":       return new HTMLBRElement();
            case "button":   return new HTMLButtonElement();
            case "caption":  return new HTMLCaptionElement();
            case "col":      return new HTMLColElement();
            case "form":     return new HTMLFormElement();
            case "h1":       return new HTMLHeadingElement(1);
            case "h2":       return new HTMLHeadingElement(2);
            case "h3":       return new HTMLHeadingElement(3);
            case "h4":       return new HTMLHeadingElement(4);
            case "h5":       return new HTMLHeadingElement(5);
            case "h6":       return new HTMLHeadingElement(6);
            case "header":   return new HTMLHeaderElement();
            case "hr":       return new HTMLHRElement();
            case "i":        return new HTMLIElement();
            case "img":      return new HTMLImageElement();
            case "input":    return new HTMLInputElement();
            case "label":    return new HTMLLabelElement();
            case "li":       return new HTMLLIElement();
            case "ol":       return new HTMLOLElement();
            case "table":    return new HTMLTableElement();
            case "tbody":    return new HTMLTBodyElement();
            case "thead":    return new HTMLTHeadElement();
            case "td":       return new HTMLTDElement();
            case "textarea": return new HTMLTextAreaElement();
            case "th":       return new HTMLTHElement();
            case "tr":       return new HTMLTRElement();
            case "ul":       return new HTMLULElement();
            case "div":      return new HTMLDivElement();
            default:         return null;
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
