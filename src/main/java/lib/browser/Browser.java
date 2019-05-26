package lib.browser;

import gui.GraphicInterface;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Browser {
    private static Browser instance;
        
    private GraphicInterface graphicInterface = new GraphicInterface();
    private LinkedList<Window> windows = new LinkedList<>();
    
    private Browser () {
        graphicInterface.setVisible(true);
    }
    
    public static Browser getInstance() {
        if (instance == null) {
            instance = new Browser();
        }
        return instance;
    }
    
    public Window getWindow() {
        return windows.get(graphicInterface.getTabPane().getSelectedIndex());
    }
        
    public void add(Window window) {
        graphicInterface.add(window.getTitle(), window.getPanel());
        windows.add(window);
        JTabbedPane pane = graphicInterface.getTabPane();
        pane.setSelectedIndex(pane.getComponentCount() - 1);
    }
       
    public static void main(String args[]) {
        setLookAndFeel();
        Browser browser = Browser.getInstance();
        browser.add(new Window("Página Inicial"));
    }
    
    public static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            Logger.getLogger(GraphicInterface.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
