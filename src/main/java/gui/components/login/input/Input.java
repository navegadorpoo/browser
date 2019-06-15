package gui.components.login.input;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import gui.components.label.StyledLabel;

public class Input extends JPanel {
    private JLabel label;
    private JTextField field;

    public Input(String label, InputType type) {
        setLayout(new GridBagLayout());
        this.field = getFieldByType(type);
        this.label = new StyledLabel(label + ": ", "teal", "12", 5);
        this.label.setLabelFor(field);
        add(this.label, getGridConstraints(0, 1));
        add(this.field, getGridConstraints(1, 1));
        setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));
    }

    public String getText() {
        return field.getText();
    }

    private JTextField getFieldByType(InputType type) {
        switch (type) {
            case TEXT: return new JTextField();
            case PASSWORD: return new JPasswordField();
            default: return null;
        }
    }

    private GridBagConstraints getGridConstraints(int gridy, int weightx) {
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridy = gridy;
        c.gridx = 0;
        c.weightx = weightx;
        return c;
    }

}
