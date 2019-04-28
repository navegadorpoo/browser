package lib.document.element;

import java.util.LinkedList;
import lib.interfaces.Renderable;
import lib.document.node.Node;
import lib.document.node.NodeType;

abstract public class Element extends Node implements Renderable {

    private LinkedList<Attribute> attributes;
    
    public Element() {
        super(NodeType.ELEMENT);
        this.attributes = new LinkedList<>();
    }
    
    public void addAttribute(Attribute attribute) {
        this.attributes.add(attribute);
    }

    public void addAttribute(String name, String value) {
        this.attributes.add(new Attribute(name, value));
    }
}
