package lib.document.node.character;

import gui.components.page.Page;
import javax.swing.JTextArea;
import lib.document.node.NodeType;

public class Comment extends CharacterData {

    public Comment(String textContent) {
        super(NodeType.COMMENT, textContent);
    }

    @Override
    public void render(Page page) {
        page.add(new JTextArea(textContent));
        page.revalidate();
    }
    
}
