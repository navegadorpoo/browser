package gui.components.login;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import gui.ResponsiveDimension;
import gui.components.login.panel.LogoutPanel;


public class Logout extends JFrame {

    public Logout() {
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setPreferredSize(new ResponsiveDimension(50, 50));
        add(new LogoutPanel());
        pack();
        setLocationRelativeTo(null);
    }
}
