package gui.components.menu;

import gui.components.menu.button.imagebutton.*;
import gui.components.menu.button.togglebutton.IncognitoButton;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;


public class Menu extends JPanel {
    UrlBar          urlBar          = new UrlBar();
    BackButton      backButton      = new BackButton();
    NextButton      nextButton      = new NextButton();
    ReloadButton    reloadButton    = new ReloadButton();
    GoButton        goButton        = new GoButton();
    BookmarkButton  bookmarkButton  = new BookmarkButton();
    LoginButton     loginButton     = new LoginButton();
    IncognitoButton incognitoButton = new IncognitoButton();
    NewTabButton    newTabButton    = new NewTabButton();
    CloseTabButton  closeTabButton  = new CloseTabButton();
    SettingsButton  settingsButton  = new SettingsButton();

    public Menu() {
        setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(170, 170, 170)));
        setLayout(new GridBagLayout());
        add(backButton, getGridConstraints(0, 0));
        add(nextButton, getGridConstraints(0, 1));
        add(reloadButton, getGridConstraints(0, 2));
        add(newTabButton, getGridConstraints(0, 3));
        add(closeTabButton, getGridConstraints(0, 4));
        add(urlBar, getGridConstraints(1, 5));
        add(goButton, getGridConstraints(0, 6));
        add(bookmarkButton, getGridConstraints(0, 7));
        add(loginButton, getGridConstraints(0, 8));
        add(incognitoButton, getGridConstraints(0, 9));
        add(settingsButton, getGridConstraints(0, 10));
    }
    
    private GridBagConstraints getGridConstraints(int weightx, int gridx) {
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridy = 0;
        c.weightx = weightx;
        c.gridx = gridx;
        return c;
    }

    public void setUrlTextContent(String url) {
        urlBar.setText(url);
    }

    public String getUrlTextContent() {
        return urlBar.getText();
    }
}
