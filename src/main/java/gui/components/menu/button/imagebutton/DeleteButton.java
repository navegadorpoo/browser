package gui.components.menu.button.imagebutton;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class DeleteButton extends ImageButton implements TableCellRenderer {

    public DeleteButton() {
        super("Apagar registro", "trash");
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        return this;
    }
}
