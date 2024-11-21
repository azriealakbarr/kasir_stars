package komponen;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Form_Produk extends JPanel {
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField txtKode, txtNama, txtJenis, txtStok, txtHarga;

    public Form_Produk() {
        setLayout(new BorderLayout());

        // Panel Tombol
        JPanel panelTombol = new JPanel();
        JButton btnTambah = new JButton("Tambah");
        JButton btnHapus = new JButton("Hapus");
        JButton btnEdit = new JButton("Edit");

        btnTambah.setBackground(Color.GREEN);
        btnHapus.setBackground(Color.RED);
        btnEdit.setBackground(Color.ORANGE);

        panelTombol.add(btnTambah);
        panelTombol.add(btnHapus);
        panelTombol.add(btnEdit);

        // Panel Form Input
        JPanel panelForm = new JPanel(new GridLayout(2, 5, 5, 5));
        txtKode = new JTextField();
        txtNama = new JTextField();
        txtJenis = new JTextField();
        txtStok = new JTextField();
        txtHarga = new JTextField();

        panelForm.add(new JLabel("Kode Produk:"));
        panelForm.add(txtKode);
        panelForm.add(new JLabel("Nama Produk:"));
        panelForm.add(txtNama);
        panelForm.add(new JLabel("Jenis Produk:"));
        panelForm.add(txtJenis);
        panelForm.add(new JLabel("Stok:"));
        panelForm.add(txtStok);
        panelForm.add(new JLabel("Harga:"));
        panelForm.add(txtHarga);

        // Tabel
        String[] kolom = {"Kode Produk", "Nama Produk", "Jenis Produk", "Stok", "Harga"};
        tableModel = new DefaultTableModel(kolom, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // Tombol Tambah Listener
        btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String kode = txtKode.getText();
                String nama = txtNama.getText();
                String jenis = txtJenis.getText();
                String stok = txtStok.getText();
                String harga = txtHarga.getText();

                if (kode.isEmpty() || nama.isEmpty() || jenis.isEmpty() || stok.isEmpty() || harga.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Semua field harus diisi!");
                } else {
                    tableModel.addRow(new Object[]{kode, nama, jenis, stok, harga});
                    clearFields();
                }
            }
        });

        // Tombol Hapus Listener
        btnHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null, "Pilih baris yang ingin dihapus!");
                } else {
                    tableModel.removeRow(selectedRow);
                }
            }
        });

        // Tombol Edit Listener
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null, "Pilih baris yang ingin diedit!");
                } else {
                    String kode = txtKode.getText();
                    String nama = txtNama.getText();
                    String jenis = txtJenis.getText();
                    String stok = txtStok.getText();
                    String harga = txtHarga.getText();

                    if (kode.isEmpty() || nama.isEmpty() || jenis.isEmpty() || stok.isEmpty() || harga.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Semua field harus diisi!");
                    } else {
                        tableModel.setValueAt(kode, selectedRow, 0);
                        tableModel.setValueAt(nama, selectedRow, 1);
                        tableModel.setValueAt(jenis, selectedRow, 2);
                        tableModel.setValueAt(stok, selectedRow, 3);
                        tableModel.setValueAt(harga, selectedRow, 4);
                        clearFields();
                    }
                }
            }
        });

        // Tambahkan komponen ke panel
        add(panelTombol, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(panelForm, BorderLayout.SOUTH);
    }

    // Membersihkan field input
    private void clearFields() {
        txtKode.setText("");
        txtNama.setText("");
        txtJenis.setText("");
        txtStok.setText("");
        txtHarga.setText("");
    }
}