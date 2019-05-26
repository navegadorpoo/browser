package gui.components.menu.button.imagebutton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import lib.browser.Browser;
import lib.browser.Window;

public class CloseTabButton extends ImageButton {
    
    public CloseTabButton() {
        super("close");
        setEvents();
    }
    
    public void setEvents() {
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Browser.getInstance().closeWindow();
            }
        });
    }
}
