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
        try {
            renderHTML((HTMLElement)document.getChild(0));
        } catch (IndexOutOfBoundsException e) {
            page.add(new JTextArea("HTML Inválido"));
            page.revalidate();
        }
        
    }
    
    private void renderHTML(HTMLElement element) {
        page.removeAll();
        element.render(page);
    }
}
