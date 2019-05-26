package gui.components.menu;

import gui.components.menu.button.imagebutton.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import lib.browser.Window;


public class Menu extends JPanel {
    Window         window;
    UrlBar         urlBar         = new UrlBar();
    BackButton     backButton     = new BackButton();
    NextButton     nextButton     = new NextButton();
    ReloadButton   reloadButton   = new ReloadButton();
    GoButton       goButton       = new GoButton();
    BookmarkButton bookmarkButton = new BookmarkButton();
    LoginButton    loginButton    = new LoginButton();
    NewTabButton   newTabButton   = new NewTabButton();
    SettingsButton settingsButton = new SettingsButton();

    public Menu() {
        setLayout(new GridBagLayout());
        add(backButton, getGridConstraints(0, 0));
        add(nextButton, getGridConstraints(0, 1));
        add(reloadButton, getGridConstraints(0, 2));
        add(newTabButton, getGridConstraints(0, 3));
        add(urlBar, getGridConstraints(1, 4));
        add(goButton, getGridConstraints(0, 5));
        add(bookmarkButton, getGridConstraints(0, 5));
        add(loginButton, getGridConstraints(0, 6));
        add(settingsButton, getGridConstraints(0, 7));
    }
    
    private GridBagConstraints getGridConstraints(int weightx, int gridx) {
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridy = 0;
        c.weightx = weightx;
        c.gridx = gridx;
        return c;
    }
}
