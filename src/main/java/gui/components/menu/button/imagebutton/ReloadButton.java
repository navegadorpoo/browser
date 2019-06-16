package gui.components.menu.button.imagebutton;

import lib.browser.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import lib.browser.Browser;

public class ReloadButton extends ImageButton {
    
    public ReloadButton() {
        super("Recarregar página", "reload");
        setEvents();
    }

    public void setEvents() {
        addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
                Window window = Browser.getInstance().getWindow();
                if (window.getPagination().getLocation() != null) {
                    Browser.getInstance().getWindow().reload();
                }
            }
        });
    }
}
