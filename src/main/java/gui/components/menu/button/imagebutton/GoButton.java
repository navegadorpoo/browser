package gui.components.menu.button.imagebutton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.components.menu.Menu;
import lib.browser.Browser;
import lib.browser.Window;

public class GoButton extends ImageButton {
    
    public GoButton() {
        super("Ir para endereço", "go");
        setEvents();
    }

    public void setEvents() {
        addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Window window = Browser.getInstance().getWindow();
                Menu menu = window.getPanel().getMenu();
                window.open(menu.getUrlTextContent());
            }
        });
    }
}
