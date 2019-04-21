package caju.browser.gui;

import caju.browser.gui.forms.MenuPanel;
import caju.browser.gui.forms.PagePanel;
import java.awt.BorderLayout;
import javax.swing.JPanel;

public class TabFactory {
    private TabFactory(){};
    
    public static JPanel makeTab() {
        JPanel mainPanel = new JPanel();
        
        mainPanel.setLayout(new BorderLayout());
        
        mainPanel.add(new MenuPanel(), BorderLayout.PAGE_START);
        mainPanel.add(new PagePanel(), BorderLayout.CENTER);
        
        return mainPanel;
    }
}