package lib.document.node.character;

import lib.interfaces.Renderable;
import lib.document.node.Node;
import lib.document.node.NodeType;

abstract public class CharacterData extends Node implements Renderable {

    private String textContent;
    
    public CharacterData(NodeType type, String textContent) {
        super(type);
        this.textContent = textContent;
    }
    
}
