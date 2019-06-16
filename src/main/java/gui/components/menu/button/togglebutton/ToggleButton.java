package gui.components.menu.button.togglebutton;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.ToolTipManager;

abstract public class ToggleButton extends JToggleButton {
    public ToggleButton(String tooltipText, String iconName, boolean active) {
        setIconName(iconName, active);
        setPreferredSize(new Dimension(40, 30));
        setContentAreaFilled(false);
        setOpaque(true);
        setTooltip(tooltipText);
    }

    public void setIconName(String iconName, boolean active) {
        String mode = active ? "-active" : "-inactive";
        setIcon(new ImageIcon("src/main/resources/" + iconName + mode + ".png"));
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

    public void setEvents() {
        addMouseListener(new MouseListener() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseReleased(MouseEvent evt) {}
            @Override
            public void mousePressed(MouseEvent evt) {}
            @Override
            public void mouseExited(MouseEvent evt) {}
            @Override
            public void mouseClicked(MouseEvent evt) {}
        });
    }
}