package komponen;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Search {
    private JFrame frame;
    private JTable table;
    private JTextField searchField;
    private DefaultTableModel tableModel;

    public Search() {
        frame = new JFrame("Search Table");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Sample data (ganti dengan data dari database Anda)
        List<String[]> data = new ArrayList<>();
        data.add(new String[]{"Produk A", "Jenis 1", "10000", "12000"});
        data.add(new String[]{"Produk B", "Jenis 2", "8000", "10000"});
        // ...

        // Kolom tabel
        String[] columnNames = {"Kode Produk", "Nama", "Jenis", "Harga Beli", "Harga Jual"};

        // Buat model tabel
        tableModel = new DefaultTableModel(data.toArray(new Object[][] {}), columnNames);
        table = new JTable(tableModel);

        // Search bar
        searchField = new JTextField(20);
        JButton searchButton = new JButton("Cari");

        // Aksi pencarian
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String keyword = searchField.getText();
                // Filter data berdasarkan keyword
                // ...
                // Update model tabel
                tableModel.fireTableDataChanged();
            }
        });

        // Layout (sesuaikan dengan layout yang Anda inginkan)
        // ...

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Search();
            }
        });
    }
}