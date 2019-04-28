package lib.document.node.character;

import lib.document.node.Node;
import lib.document.node.NodeType;

public class Comment extends CharacterData {

    public Comment(String textContent) {
        super(NodeType.COMMENT, textContent);
    }

    @Override
    public void render() {
        
    }
    
}
