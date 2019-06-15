package gui.components.menu.button.imagebutton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.components.login.Login;

public class LoginButton extends ImageButton {
    
    public LoginButton() {
        super("user");
        setEvents();
    }

    public void setEvents() {
        addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
                Login login = new Login();
                login.setVisible(true);
            }
        });
    }
}
