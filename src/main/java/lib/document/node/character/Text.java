package lib.document.node.character;

import lib.document.node.Node;
import lib.document.node.NodeType;

public class Text extends CharacterData {

    public Text(String textContent) {
        super(NodeType.TEXT, textContent);
    }

    @Override
    public void render() {
        
    }
    
}
