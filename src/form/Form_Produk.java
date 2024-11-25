package form;

import db.db_connection;
import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Form_Produk extends javax.swing.JPanel {

    private DefaultTableModel tableModel;

    public Form_Produk() {
        initComponents();
        initializeTable(); // Inisialisasi tabel

        tbl_produk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int selectedRow = tbl_produk.getSelectedRow(); // Mendapatkan indeks baris yang diklik
                if (selectedRow != -1) { // Pastikan ada baris yang dipilih
                    // Ambil nilai dari baris yang dipilih dan masukkan ke text field
                    tf_kode.setText(tbl_produk.getValueAt(selectedRow, 0).toString());
                    tf_nama.setText(tbl_produk.getValueAt(selectedRow, 1).toString());
                    tf_jenis.setText(tbl_produk.getValueAt(selectedRow, 2).toString());
                    tf_hBeli.setText(tbl_produk.getValueAt(selectedRow, 3).toString());
                    tf_hJual.setText(tbl_produk.getValueAt(selectedRow, 4).toString());

                    // Atur tombol (disable tambah, enable edit dan hapus)
                    btnTambah.setEnabled(false);
                    btnEdit.setEnabled(true);
                    btnHapus.setEnabled(true);
                }
            }
        });
    }

    private void initializeTable() {
        // Mengatur model tabel
        tableModel = new DefaultTableModel(new String[]{"Kode Produk", "Nama", "Jenis", "Harga Beli", "Harga Jual"}, 0);
        tbl_produk.setModel(tableModel);
    }

    private void clearForm() {
        // Membersihkan form input
        tf_kode.setText("");
        tf_nama.setText("");
        tf_jenis.setText("");
        tf_hBeli.setText("");
        tf_hJual.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnTambah = new swing.button_login();
        btnEdit = new swing.button_login();
        btnHapus = new swing.button_login();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_produk = new javax.swing.JTable();
        tf_kode = new swing.mytext_field_login();
        tf_nama = new swing.mytext_field_login();
        tf_jenis = new swing.mytext_field_login();
        tf_hBeli = new swing.mytext_field_login();
        tf_hJual = new swing.mytext_field_login();
        lb_kode = new javax.swing.JLabel();
        lb_jenis = new javax.swing.JLabel();
        lb_nama = new javax.swing.JLabel();
        lb_hBeli = new javax.swing.JLabel();
        lb_hJual = new javax.swing.JLabel();

        setBackground(new java.awt.Color(242, 242, 242));

        btnTambah.setBackground(new java.awt.Color(153, 255, 0));
        btnTambah.setLabel("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(255, 204, 0));
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnHapus.setBackground(new java.awt.Color(255, 0, 0));
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        tbl_produk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Kode Produk", "Nama", "Jenis", "Harga Beli", "Harga Jual", "Stok"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_produk);
        if (tbl_produk.getColumnModel().getColumnCount() > 0) {
            tbl_produk.getColumnModel().getColumn(5).setResizable(false);
            tbl_produk.getColumnModel().getColumn(5).setPreferredWidth(10);
        }

        tf_kode.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tf_kode.setForeground(new java.awt.Color(0, 0, 0));
        tf_kode.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_kode.setHint(" contoh : MA010001");
        tf_kode.setSelectionColor(new java.awt.Color(255, 255, 255));
        tf_kode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_kodeActionPerformed(evt);
            }
        });

        tf_nama.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tf_nama.setForeground(new java.awt.Color(0, 0, 0));
        tf_nama.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_nama.setHint(" contoh : Chitato");
        tf_nama.setSelectionColor(new java.awt.Color(255, 255, 255));
        tf_nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_namaActionPerformed(evt);
            }
        });

        tf_jenis.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tf_jenis.setForeground(new java.awt.Color(0, 0, 0));
        tf_jenis.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_jenis.setHint(" contoh : Makanan");
        tf_jenis.setSelectionColor(new java.awt.Color(255, 255, 255));
        tf_jenis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_jenisActionPerformed(evt);
            }
        });

        tf_hBeli.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tf_hBeli.setForeground(new java.awt.Color(0, 0, 0));
        tf_hBeli.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_hBeli.setToolTipText("");
        tf_hBeli.setHint(" contoh : 2500");
        tf_hBeli.setSelectionColor(new java.awt.Color(255, 255, 255));
        tf_hBeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_hBeliActionPerformed(evt);
            }
        });

        tf_hJual.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tf_hJual.setForeground(new java.awt.Color(0, 0, 0));
        tf_hJual.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_hJual.setToolTipText("");
        tf_hJual.setHint(" contoh : 2500");
        tf_hJual.setSelectionColor(new java.awt.Color(255, 255, 255));
        tf_hJual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_hJualActionPerformed(evt);
            }
        });

        lb_kode.setText("Kode Produk");

        lb_jenis.setText("Jenis");

        lb_nama.setText("Nama");

        lb_hBeli.setText("Harga Beli");

        lb_hJual.setText("Harga Jual");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lb_kode)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_kode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lb_nama)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lb_hBeli, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lb_jenis)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tf_hBeli, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lb_hJual)
                                        .addGap(18, 18, 18)
                                        .addComponent(tf_hJual, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(tf_jenis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tf_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 235, Short.MAX_VALUE))
                            .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lb_kode)
                    .addComponent(tf_kode, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_nama))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_jenis, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_jenis)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_hBeli, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_hJual, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_hJual)
                    .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_hBeli))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );

        btnEdit.getAccessibleContext().setAccessibleDescription("");
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        int selectedRow = tbl_produk.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data yang ingin diedit!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String kode = tf_kode.getText().trim();
        String nama = tf_nama.getText().trim();
        String jenis = tf_jenis.getText().trim();
        String hargaBText = tf_hBeli.getText().trim();
        String hargaJText = tf_hJual.getText().trim();

        // Validasi input
        if (kode.isEmpty() || nama.isEmpty() || jenis.isEmpty() || hargaBText.isEmpty() || hargaJText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua kolom harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String sqlEdit = "UPDATE produk (product_code, product_name, category, price_purchase, price_sales, stock) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            double hargaB = Double.parseDouble(hargaBText); // Validasi harga\
            double hargaJ = Double.parseDouble(hargaJText); // Validasi harga\

            tableModel.setValueAt(kode, selectedRow, 0);
            tableModel.setValueAt(nama, selectedRow, 1);
            tableModel.setValueAt(jenis, selectedRow, 2);
            tableModel.setValueAt(hargaB, selectedRow, 3);
            tableModel.setValueAt(hargaJ, selectedRow, 4);

            JOptionPane.showMessageDialog(this, "Data berhasil diedit!");
            clearForm();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Harga harus berupa angka!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }


    }//GEN-LAST:event_btnEditActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // Menghapus data dari tabel
        int selectedRow = tbl_produk.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data yang ingin dihapus!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirmation = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menghapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (confirmation == JOptionPane.YES_OPTION) {
            tableModel.removeRow(selectedRow);
            JOptionPane.showMessageDialog(this, "Data berhasil dihapus!");
            clearForm();
        }

    }//GEN-LAST:event_btnHapusActionPerformed

    private void tf_kodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_kodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_kodeActionPerformed

    private void tf_namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_namaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_namaActionPerformed

    private void tf_hBeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_hBeliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_hBeliActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // Mengambil data dari form input
        String kode = tf_kode.getText().trim();
        String nama = tf_nama.getText().trim();
        String jenis = tf_jenis.getText().trim();
        String hargaBText = tf_hBeli.getText().trim();
        String hargaJText = tf_hJual.getText().trim();

        // Validasi input
        if (kode.isEmpty() || nama.isEmpty() || jenis.isEmpty() || hargaBText.isEmpty() || hargaJText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua kolom harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            double hargaB = Double.parseDouble(hargaBText); // Validasi harga beli
            double hargaJ = Double.parseDouble(hargaJText); // Validasi harga jual

            // Query untuk menambahkan data ke database
            String sqlTambah = "INSERT INTO produk (product_code, product_name, category, price_purchase, price_sales, stock) VALUES (?, ?, ?, ?, ?, ?)";
            try (Connection koneksi = db_connection.getInstance().getConnection(); PreparedStatement pst = koneksi.prepareStatement(sqlTambah)) {

                pst.setString(1, kode);       // Mengisi kolom product_code
                pst.setString(2, nama);       // Mengisi kolom product_name
                pst.setString(3, jenis);      // Mengisi kolom category
                pst.setDouble(4, hargaB);     // Mengisi kolom price_purchase
                pst.setDouble(5, hargaJ);     // Mengisi kolom price_sales
                pst.setInt(6, 0);             // Stok awal = 0 (default)

                pst.executeUpdate(); // Eksekusi query SQL
                JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan ke database!");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error saat menyimpan data ke database: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Tambahkan data ke tabel GUI
            Object[] rowData = {kode, nama, jenis, hargaB, hargaJ, 0}; // Tambahkan stok awal 0
            tableModel.addRow(rowData);

            // Bersihkan form input
            clearForm();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Harga harus berupa angka!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }


    }//GEN-LAST:event_btnTambahActionPerformed

    private void tf_jenisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_jenisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_jenisActionPerformed

    private void tf_hJualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_hJualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_hJualActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.button_login btnEdit;
    private swing.button_login btnHapus;
    private swing.button_login btnTambah;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_hBeli;
    private javax.swing.JLabel lb_hJual;
    private javax.swing.JLabel lb_jenis;
    private javax.swing.JLabel lb_kode;
    private javax.swing.JLabel lb_nama;
    private javax.swing.JTable tbl_produk;
    private swing.mytext_field_login tf_hBeli;
    private swing.mytext_field_login tf_hJual;
    private swing.mytext_field_login tf_jenis;
    private swing.mytext_field_login tf_kode;
    private swing.mytext_field_login tf_nama;
    // End of variables declaration//GEN-END:variables
}
