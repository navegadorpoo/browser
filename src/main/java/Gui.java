import gui.TabFactory;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

public class Gui extends JFrame {

    public Gui() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        // Create the main layout of the browser
        GroupLayout mainLayout = new GroupLayout(getContentPane());
        getContentPane().setLayout(mainLayout);
        
        // Create and setup the TabPanel
        JTabbedPane tabPane = new JTabbedPane();
        mainLayout.setHorizontalGroup(
            mainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(tabPane, GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        mainLayout.setVerticalGroup(
            mainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(tabPane, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        
        // Add examples tab, must be substituted by a click event
        tabPane.addTab("microsoft", TabFactory.makeTab());
        tabPane.addTab("google", TabFactory.makeTab());
        tabPane.addTab("facebook", TabFactory.makeTab());
        tabPane.addTab("facebook", TabFactory.makeTab());
        tabPane.addTab("facebook", TabFactory.makeTab());
        tabPane.addTab("facebook", TabFactory.makeTab());
        tabPane.addTab("facebook", TabFactory.makeTab());

        pack();
    }
    
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gui().setVisible(true);
            }
        });
    }
}
