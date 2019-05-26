package gui.components.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MouseDeleteTableRowListener implements MouseListener {
    
    @Override
    public void mouseClicked(MouseEvent evt) {
        JTable table = (JTable) evt.getSource();
        int row = table.rowAtPoint(evt.getPoint());
        int column = table.columnAtPoint(evt.getPoint());
        if (column != table.getModel().getColumnCount() - 1) {
            return;
        }

        int answer = JOptionPane.showConfirmDialog(null,
            "Tem certeza que deseja remover esse registro?",
            "Atenção",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.ERROR_MESSAGE
        );
        if (answer == 0) {
            ((DefaultTableModel) table.getModel()).removeRow(row);   
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {

    }

    @Override
    public void mouseReleased(MouseEvent me) {

    }

    @Override
    public void mouseEntered(MouseEvent me) {

    }

    @Override
    public void mouseExited(MouseEvent me) {

    }
}
