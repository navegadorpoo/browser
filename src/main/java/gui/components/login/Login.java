package gui.components.login;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import gui.ResponsiveDimension;
import gui.components.login.panel.LoginPanel;


public class Login extends JFrame {

    public Login() {
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setPreferredSize(new ResponsiveDimension(50, 50));
        add(new LoginPanel());
        pack();
        setLocationRelativeTo(null);
    }
}
