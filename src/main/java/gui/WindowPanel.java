package gui;

import gui.components.menu.Menu;
import gui.components.page.Page;
import java.awt.BorderLayout;
import javax.swing.JPanel;

public class WindowPanel extends JPanel {
    
    private Menu menu = new Menu();
    private Page page = new Page();
            
    public WindowPanel() {
        setLayout(new BorderLayout());
        add(menu, BorderLayout.PAGE_START);
        add(page, BorderLayout.CENTER);
    }

    public Menu getMenu() {
        return menu;
    }

    public Page getPage() {
        return page;
    }
    
}
