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
        
    private GraphicInterface graphicInterface;
    private LinkedList<Window> windows;
    private User user;
    
    private Browser () {
        init();
    }

    private void init() {
        this.user = User.defaultUser();
        setUp();
    }

    private void init(User user) {
        this.user = user;
        setUp();
    }

    private void setUp() {
        windows          = new LinkedList<>();
        graphicInterface = new GraphicInterface();
        graphicInterface.setVisible(true);
        addWindow(new Window("Página Inicial"));
    }

    private void close() {
        graphicInterface.setVisible(false);
    }
    
    public static Browser getInstance() {
        if (instance == null) {
            instance = new Browser();
        }
        return instance;
    }
    
    public void changeSelectedTabTitle(String title) {
        JTabbedPane tab = graphicInterface.getTabPane();
        tab.setTitleAt(tab.getSelectedIndex(), title);
    }
    
    public Window getWindow() {
        return windows.get(graphicInterface.getTabPane().getSelectedIndex());
    }
        
    public void addWindow(Window window) {
        graphicInterface.add(window.getTitle(), window.getPanel());
        windows.add(window);
        JTabbedPane pane = graphicInterface.getTabPane();
        pane.setSelectedIndex(pane.getComponentCount() - 1);
    }
    
    public void closeWindow() {
        JTabbedPane pane = graphicInterface.getTabPane();
        if (pane.getComponentCount() > 1) {
            pane.remove(pane.getSelectedComponent());
        }
    }

    public void login(User user) {
        close();
        init(user);
    }
    
    public User getUser() {
        return user;
    }
       
    public static void main(String args[]) {
        setLookAndFeel();
        Browser browser = Browser.getInstance();
    }
    
    public static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            Logger.getLogger(GraphicInterface.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
