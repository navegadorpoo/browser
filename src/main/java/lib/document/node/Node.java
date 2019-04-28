package lib.document.node;

import java.util.LinkedList;

abstract public class Node {
    
    private NodeType type;
    private Node parent;

    private LinkedList<Node> children;
    
    public Node(NodeType type) {
        this.children = new LinkedList<>();
        this.type = type;
    }
    
    public void appendChild(Node node) {
        node.setParent(this);
        children.add(node);
    }
    
    public Node getChild(int index) {
        return children.get(index);
    }
    
    public void setParent(Node parent) {
        this.parent = parent;
    }
}
