package lib.document.element.html;

import gui.components.page.Page;
import lib.browser.Browser;
import lib.document.node.character.Text;

public class HTMLTitleElement extends HTMLElement {

    @Override
    public void render(Page page) {
        String text = "";
        try {
            text = ((Text)getChild(0)).getTextContent();
        } catch (IndexOutOfBoundsException e) {
            text = "Sem Título";
        } finally {
            Browser.getInstance().getWindow().setTitle(text);
        }
    }
    
}
