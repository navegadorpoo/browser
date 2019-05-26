package gui;

import gui.components.menu.Menu;
import gui.components.page.Page;
import java.awt.BorderLayout;
import javax.swing.JPanel;

public class TabFactory {
    private TabFactory(){};
    
    public static JPanel makeTab() {
        JPanel mainPanel = new JPanel();
        
        mainPanel.setLayout(new BorderLayout());
        
        mainPanel.add(new Menu(), BorderLayout.PAGE_START);
        mainPanel.add(new Page(), BorderLayout.CENTER);
        
        return mainPanel;
    }
}
