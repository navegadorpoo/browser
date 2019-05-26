package lib.document.node.character;

import gui.components.page.Page;
import javax.swing.JTextArea;
import lib.document.node.NodeType;

public class Text extends CharacterData {

    public Text(String textContent) {
        super(NodeType.TEXT, textContent);
    }

    @Override
    public void render(Page page) {
        page.add(new JTextArea(textContent));
        page.revalidate();
    }
    
}
