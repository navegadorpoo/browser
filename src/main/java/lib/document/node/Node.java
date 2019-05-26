package lib.document.node;

import gui.components.page.Page;
import java.util.LinkedList;
import javax.swing.JTextArea;
import lib.interfaces.Renderable;

abstract public class Node implements Renderable {
    
    private NodeType type;
    private Node parent;

    protected LinkedList<Node> children;
    
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
   
    @Override
    public void render(Page page) {
//        page.add(new JTextArea(this.getClass().toString()));
//        page.revalidate();
        for (Node child : children) {
            child.render(page);
        }
    }
}
