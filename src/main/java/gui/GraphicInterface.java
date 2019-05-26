package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;

public class GraphicInterface extends JFrame {

    private BorderLayout layout = new BorderLayout();
    private JTabbedPane tabPane = new JTabbedPane();

    public GraphicInterface() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new ResponsiveDimension(70, 70));
        setMinimumSize(new ResponsiveDimension(40, 40));
        setLayout(layout);
        add(tabPane);
        pack();
        setLocationRelativeTo(null);
    }

    public void add(String title, JPanel window) {
        tabPane.add(title, window);
    }

    public JTabbedPane getTabPane() {
        return tabPane;
    }
}
