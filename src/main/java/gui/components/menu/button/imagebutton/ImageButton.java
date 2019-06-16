package gui.components.menu.button.imagebutton;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.ToolTipManager;

abstract public class ImageButton extends JButton {
    public ImageButton(String tooltipText, String iconName) {
        setIcon(new ImageIcon("src/main/resources/" + iconName + ".png"));
        setPreferredSize(new Dimension(40, 30));
        setTooltip(tooltipText);
    }

    public void setTooltip(String tooltipText) {
        ToolTipManager tooltip = ToolTipManager.sharedInstance();
        tooltip.setInitialDelay(300);
        tooltip.setDismissDelay(5000);
        setToolTipText(String.format(
              "<html>"
            +     "<div style='padding:5px;'>"
            +         "<span>%s</span>"
            +     "</div>"
            + "</html>", tooltipText)
        );
    }
}