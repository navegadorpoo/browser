package gui.components.menu.button.imagebutton;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;

abstract public class ImageButton extends JButton {
    public ImageButton(String iconName) {
        setIcon(new ImageIcon("src/main/resources/" + iconName + ".png"));
        setPreferredSize(new Dimension(40, 30));
    }
}