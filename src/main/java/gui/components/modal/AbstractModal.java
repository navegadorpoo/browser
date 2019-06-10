package gui.components.modal;

import gui.ResponsiveDimension;
import gui.components.listener.ModelDeleteListener;
import gui.components.menu.button.imagebutton.DeleteButton;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

abstract public class AbstractModal extends JFrame {
    protected DefaultTableModel model;
    protected JScrollPane scrollPane = new JScrollPane();
    protected JTable table = new JTable();
    protected String[] columns;

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
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
            
        };
        
        table.setModel(model);
        table.setRowSelectionAllowed(false);
        table.setRowHeight(30);
        table.addMouseListener(new ModelDeleteListener());
        
        // remove id column
        table.removeColumn(table.getColumnModel().getColumn(0));
        
        // style remove column
        TableColumn column = table.getColumnModel().getColumn(model.getColumnCount() - 2);
        column.setMaxWidth(70);
        column.setCellRenderer(new DeleteButton());
        
        scrollPane.setViewportView(table);
        add(scrollPane);
    }
}
