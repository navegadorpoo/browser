package gui.components.menu.button.imagebutton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import lib.browser.Browser;

public class ReloadButton extends ImageButton {
    
    public ReloadButton() {
        super("reload");
        setEvents();
    }

    public void setEvents() {
        addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
                Browser.getInstance().getWindow().reload();
            }
        });
    }
}
