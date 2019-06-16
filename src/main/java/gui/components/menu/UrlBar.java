package gui.components.menu;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;
import lib.browser.Browser;

public class UrlBar extends JTextField {
    public UrlBar() {
        setPreferredSize(new Dimension(30, 30));
        setEvents();
    }

    private void setEvents() {
        addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent evt) {
                if (evt.getKeyCode() != 10) {
                    return;
                }
                Browser.getInstance().getWindow().open(getText());
            }

            @Override
            public void keyTyped(KeyEvent evt) {}

            @Override
            public void keyReleased(KeyEvent evt) {}
        });
    }
}