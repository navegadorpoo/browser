package gui.components.login.panel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.components.label.StyledLabel;
import lib.browser.Browser;
import lib.browser.User;
import lib.browser.Window;

public class LogoutPanel extends JPanel {
    Browser browser   = Browser.getInstance();
    Window  window    = browser.getWindow();
    User    user      = browser.getUser();
    int     visited   = window.getHistory().count();
    int     bookmarks = window.getBookmarkList().count();
    JButton logout    = new JButton("Sair");

    public LogoutPanel() {
        setLayout(new GridBagLayout());
        setBorder(new EmptyBorder(50, 50, 50, 50));

        String greeting = String.format("Olá %s!", user.getFirstName());
        add(new StyledLabel(greeting, "teal", "30", 30), getGridConstraints(0));

        String pageCount = String.format("Você já visitou %d páginas utilizando nosso navegador", visited);
        add(new StyledLabel(pageCount, "teal", "14", 30), getGridConstraints(1));

        String bookmarkCount = String.format("E também adicionou %d páginas aos favoritos", bookmarks);
        add(new StyledLabel(bookmarkCount, "teal", "14", 30), getGridConstraints(2));

        add(logout, getGridConstraints(3));
        setEvents();
    }

    private GridBagConstraints getGridConstraints(int gridy) {
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridy = gridy;
        c.weightx = 1;
        return c;
    }

    private void setEvents() {
        logout.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
                Browser.getInstance().logout();
            }
        });
    }
}
