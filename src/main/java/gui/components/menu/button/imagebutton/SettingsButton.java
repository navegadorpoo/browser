package gui.components.menu.button.imagebutton;

import gui.components.menu.popup.popupmenu.SettingsPopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;

public class SettingsButton extends ImageButton {
    private SettingsPopupMenu popupMenu = new SettingsPopupMenu();
    
    public SettingsButton() {
        super("settings");
        setEvents();
    }
    
    public final void setEvents() {
        JComponent self = this;
        addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                popupMenu.show(self, -getWidth(), getHeight());
            }
        });
    }
}
