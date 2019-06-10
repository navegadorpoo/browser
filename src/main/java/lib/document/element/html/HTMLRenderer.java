package lib.document.element.html;

import gui.components.page.Page;
import javax.swing.JTextArea;
import lib.document.Document;

public class HTMLRenderer {
    Page page;
    public HTMLRenderer(Page page) {
        this.page = page;
    }
    
    public void render(Document document) {
        page.removeAll();
        
        if (document.countChildren() == 0) {
            page.add(new JTextArea("404 Not Found"));
            page.revalidate();
            return;
        }

        renderHTML((HTMLElement)document.getChild(0));
    }
    
    private void renderHTML(HTMLElement element) {
        element.render(page);
    }
}
