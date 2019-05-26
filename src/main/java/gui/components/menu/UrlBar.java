package gui.components.menu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;
import lib.URLReader;
import lib.browser.Browser;
import lib.browser.Window;
import lib.document.element.html.HTMLParser;

public class UrlBar extends JTextField {
    public UrlBar() {
        setEvents();
    }
    
    private void setEvents() {
        JTextField self = this;
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent evt) {
                //faz nada
            }
            
            @Override
            public void keyPressed(KeyEvent evt) {
                if (evt.getKeyCode() != 10) {
                    return;
                }
                Browser.getInstance().getWindow().open(self.getText());
            }

            @Override
            public void keyReleased(KeyEvent evt) {
                //faz nada
            }
        });
    }
}