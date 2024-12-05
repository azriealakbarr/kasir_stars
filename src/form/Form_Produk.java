package form;

import db.db_connection;
import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Form_Produk extends javax.swing.JPanel {

    private DefaultTableModel tableModel;
    private Connection conn = db_connection.connect(); 

    public Form_Produk() {
        initComponents();
        initializeTable(); // Inisialisasi tabel
        loadTableData();

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
        tableModel = new DefaultTableModel(new String[]{"Kode Produk", "Nama", "Jenis", "Harga Beli", "Harga Jual", "Stok"}, 0);
        tbl_produk.setModel(tableModel);
    }

    private void loadTableData() {
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM produk")) {

            DefaultTableModel model = (DefaultTableModel) tbl_produk.getModel();
            model.setRowCount(0); // Hapus data tabel

            while (rs.next()) {
                Object[] row = {
                    rs.getString("product_code"),
                    rs.getString("product_name"),
                    rs.getString("category"),
                    rs.getDouble("price_purchase"),
                    rs.getDouble("price_sales"),
                    rs.getInt("stock")
                };
                model.addRow(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
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

        btnTambah = new swing.Button();
        btnEdit = new swing.Button();
        btnHapus = new swing.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_produk = new javax.swing.JTable();
        tf_kode = new swing.TextField();
        tf_nama = new swing.TextField();
        tf_jenis = new swing.TextField();
        tf_hBeli = new swing.TextField();
        tf_hJual = new swing.TextField();
        lb_kode = new javax.swing.JLabel();
        lb_jenis = new javax.swing.JLabel();
        lb_nama = new javax.swing.JLabel();
        lb_hBeli = new javax.swing.JLabel();
        lb_hJual = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

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
                            .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 235, Short.MAX_VALUE)))
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
// Ambil data dari text field
        String kodeProduk = tf_kode.getText();
        String namaProduk = tf_nama.getText();
        String jenisProduk = tf_jenis.getText();
        String hargaBeli = tf_hBeli.getText();
        String hargaJual = tf_hJual.getText();

        // Validasi input
        if (kodeProduk.isEmpty() || namaProduk.isEmpty() || jenisProduk.isEmpty() || hargaBeli.isEmpty() || hargaJual.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Harap lengkapi semua data!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            String query = "UPDATE produk SET product_name = ?, category = ?, price_purchase = ?, price_sales = ? WHERE product_code = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);

            // Set parameter query
            pstmt.setString(1, namaProduk);
            pstmt.setString(2, jenisProduk);
            pstmt.setDouble(3, Double.parseDouble(hargaBeli));
            pstmt.setDouble(4, Double.parseDouble(hargaJual));
            pstmt.setString(5, kodeProduk);

            // Eksekusi update
            int rowsUpdated = pstmt.executeUpdate();

            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "Data berhasil diperbarui!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                loadTableData(); // Refresh tabel
                clearForm();     // Bersihkan form
                btnTambah.setEnabled(true);
                btnEdit.setEnabled(false);
                btnHapus.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(this, "Gagal memperbarui data!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Harga beli/jual harus berupa angka!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        int selectedRow = tbl_produk.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Pilih data yang ingin dihapus!");
            return;
        }
        
        // Ambil kode produk dari tabel
        String kodeProduk = (String) tbl_produk.getValueAt(selectedRow, 0);

        // Konfirmasi penghapusan
        int confirm = JOptionPane.showConfirmDialog(null,
                "Apakah Anda yakin ingin menghapus produk dengan kode: " + kodeProduk + "?",
                "Konfirmasi Hapus",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            String query = "DELETE FROM produk WHERE product_code = ?";

            try (PreparedStatement pstmt = conn.prepareStatement(query)) {

                pstmt.setString(1, kodeProduk);
                int rowsDeleted = pstmt.executeUpdate();

                if (rowsDeleted > 0) {
                    JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
                    loadTableData(); // Refresh tabel
                    clearForm();     // Bersihkan form
                } else {
                    JOptionPane.showMessageDialog(null, "Data tidak ditemukan!");
                }

            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
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
        String kode = tf_kode.getText();
        String nama = tf_nama.getText();
        String jenis = tf_jenis.getText();
        double hBeli = Double.parseDouble(tf_hBeli.getText());
        double hJual = Double.parseDouble(tf_hJual.getText());

        String query = "INSERT INTO produk (product_code, product_name, category, price_purchase, price_sales) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, kode);
            pstmt.setString(2, nama);
            pstmt.setString(3, jenis);
            pstmt.setDouble(4, hBeli);
            pstmt.setDouble(5, hJual);

            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan!");

            clearForm();  // Bersihkan form
            loadTableData();  // Refresh tabel

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_btnTambahActionPerformed

    private void tf_jenisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_jenisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_jenisActionPerformed

    private void tf_hJualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_hJualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_hJualActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button btnEdit;
    private swing.Button btnHapus;
    private swing.Button btnTambah;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_hBeli;
    private javax.swing.JLabel lb_hJual;
    private javax.swing.JLabel lb_jenis;
    private javax.swing.JLabel lb_kode;
    private javax.swing.JLabel lb_nama;
    private javax.swing.JTable tbl_produk;
    private swing.TextField tf_hBeli;
    private swing.TextField tf_hJual;
    private swing.TextField tf_jenis;
    private swing.TextField tf_kode;
    private swing.TextField tf_nama;
    // End of variables declaration//GEN-END:variables
}
