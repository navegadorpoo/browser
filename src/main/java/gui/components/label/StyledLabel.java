package gui.components.label;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class StyledLabel extends JLabel {

    public StyledLabel(String text, String color, String size, int marginBottom) {
        setBorder(BorderFactory.createEmptyBorder(0, 0, marginBottom, 0));
        setText(String.format(
              "<html>"
            + "  <span style='color: %s; font-size:%spx;'>%s</span>"
            + "</html>"
        , color, size, text));
    }
}
