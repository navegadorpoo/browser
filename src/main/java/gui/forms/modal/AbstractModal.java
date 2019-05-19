package gui.forms.modal;

import java.util.Calendar;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

abstract public class AbstractModal {
    JFrame frame;
    GroupLayout layout;
    DefaultTableModel model;
    JScrollPane scrollPane;
    JTable table;
    String[] columns;

    public AbstractModal(String[] columns) {
        this.columns = columns;
        
        init();
        setModel();
        setLayout();
        frame.pack();
    }
    
    public void init() {
        frame = new JFrame();
        layout = new GroupLayout(frame.getContentPane());
        scrollPane = new JScrollPane();
        table = new JTable();
        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
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
    }
    
    public void setLayout() {
        scrollPane.setViewportView(table);

        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
    }
    
    public void show() {
        frame.setVisible(true);
    }
    
}
