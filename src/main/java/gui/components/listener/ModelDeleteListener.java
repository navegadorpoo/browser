package gui.components.listener;

import gui.components.interaction.Dialog;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import lib.browser.Browser;

public class ModelDeleteListener implements MouseListener {
    
    @Override
    public void mouseClicked(MouseEvent evt) {
        JTable table = (JTable) evt.getSource();
        int row = table.rowAtPoint(evt.getPoint());
        int column = table.columnAtPoint(evt.getPoint());
        TableModel model = table.getModel();
        
        if (column != model.getColumnCount() - 2) {
            return;
        }
        
        int answer = Dialog.showConfirm(
            "Atenção",
            "Tem certeza que deseja remover esse registro?"
        );
        
        if (answer == 0) {
            remove(table.getName(), Integer.parseInt(model.getValueAt(row, 0).toString()));
            ((DefaultTableModel) model).removeRow(row);
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
        // do nothing
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        // do nothing
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        // do nothing
    }

    @Override
    public void mouseExited(MouseEvent me) {
        // do nothing
    }
    
    public void remove(String name, int id) {
        try {
            switch (name) {
                case "history":
                    Browser.getInstance().getWindow().getHistory().delete(id);    
                    break;
                case "bookmark":
                    Browser.getInstance().getWindow().getBookmarkList().delete(id);
                    break;
            }
            Dialog.showMessage(
                "success",
                "Sucesso",
                "Registro excluído com sucesso"
            );
        } catch (SQLException e) {
            Dialog.showMessage(
                "error",
                "Atenção",
                "Erro ao excluir o registro"
            );
        }
    }
}
