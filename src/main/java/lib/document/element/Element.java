package lib.document.element;

import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lib.document.node.Node;
import lib.document.node.NodeType;

abstract public class Element extends Node {

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
    
    public String getAttribute(String name) {
        Stream<Attribute> attrs = attributes.stream();
        Attribute attr = attrs.filter(att -> att.getName().equals(name))
                .findAny().orElse(null);
        return attr != null ? attr.getValue() : "";
    }
}
