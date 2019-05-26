package gui.components.menu.button.imagebutton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import lib.browser.Browser;
import lib.browser.Window;

public class NewTabButton extends ImageButton {
    
    public NewTabButton() {
        super("soma");
        setEvents();
    }
    
    public void setEvents() {
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Browser.getInstance().add(new Window("Sem Título"));
            }
        });
    }
}
