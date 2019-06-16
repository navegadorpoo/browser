package gui.components.menu.button.imagebutton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import lib.browser.Browser;
import lib.browser.Window;

public class NextButton extends ImageButton {
    
    public NextButton() {
        super("Avançar", "right_arrow");
        setEvents();
    }

    public void setEvents() {
        addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
                Window window = Browser.getInstance().getWindow();
                if (window.getPagination().hasForward()) {
                    window.next();
                }
            }
        });
    }
}
