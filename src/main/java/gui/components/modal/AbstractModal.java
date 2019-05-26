package gui.components.modal;

import gui.ResponsiveDimension;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

abstract public class AbstractModal extends JFrame {
    DefaultTableModel model;
    JScrollPane scrollPane = new JScrollPane();
    JTable table = new JTable();
    String[] columns;

    public AbstractModal(String[] columns) {
        this.columns = columns;
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setPreferredSize(new ResponsiveDimension(50, 50));
        setModel();
        pack();
        setLocationRelativeTo(null);
    }
    
    public void setModel() {
        model = new DefaultTableModel(new Object[][]{}, columns) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        };
        
        table.setModel(model);
        scrollPane.setViewportView(table);
        add(scrollPane);
    }
}
