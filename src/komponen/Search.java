package komponen;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Search extends JPanel {
    private JTextField searchField;
    private JTable table;
    private DefaultTableModel tableModel;

    public Search(JTable table, DefaultTableModel tableModel) {
        this.table = table;
        this.tableModel = tableModel;

        searchField = new JTextField();
        searchField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String keyword = searchField.getText();
                // Filter data based on keyword
                // ...
                // Update table model
                tableModel.fireTableDataChanged();
            }
        });

        add(searchField); // Add the search field to the panel
    }
}