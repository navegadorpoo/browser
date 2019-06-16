package gui.components.menu.button.imagebutton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.components.login.Login;
import gui.components.login.Logout;
import lib.browser.Browser;

public class LoginButton extends ImageButton {
    
    public LoginButton() {
        super("Efetuar login", "user");
        setEvents();
    }

    public void setEvents() {
        addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (Browser.getInstance().isLogged()) {
                    Logout logout = new Logout();
                    logout.setVisible(true);
                } else {
                    Login login = new Login();
                    login.setVisible(true);
                }
            }
        });
    }
}
