package gui.components.menu.button.togglebutton;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import lib.browser.Browser;

public class IncognitoButton extends ToggleButton {

    public IncognitoButton() {
        super("Ativar/Desativar modo anônimo", "incognito", Browser.getInstance().isIncognito());
        setEvents();
    }

    public void setEvents() {
        super.setEvents();
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Browser.getInstance().toggleIncognito();
                setIconName("incognito", Browser.getInstance().isIncognito());
            }
        });
    }
}
