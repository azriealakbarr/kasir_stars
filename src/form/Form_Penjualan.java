package form;

import db.db_connection;
import frame.frameJual;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import user.PenggunaLogin;

public class Form_Penjualan extends javax.swing.JPanel {

    private DefaultTableModel model;
    private boolean isSaving = false;
    private Connection conn = db.db_connection.connect();

    public Form_Penjualan() {
        initComponents();
    }

    public void clearForm() {
        kodeT.setText("");
        kodeP.setText("");
        namaP.setText("");
        hargaP.setText("");
        jmlP.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kodeT = new swing.TextField();
        kodeP = new swing.TextField();
        namaP = new swing.TextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jmlP = new swing.TextField();
        jLabel5 = new javax.swing.JLabel();
        hargaP = new swing.TextField();
        btnTambah = new swing.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblJual = new javax.swing.JTable();
        btnSimpan = new swing.Button();
        ttl_Bayar = new swing.TextField();
        jLabel6 = new javax.swing.JLabel();
        tf_Bayar = new swing.TextField();
        tf_Kembali = new swing.TextField();
        jLabel7 = new javax.swing.JLabel();
        btnBayar = new swing.Button();
        jLabel8 = new javax.swing.JLabel();
        btnPanggil = new swing.Button();
        cbDate = new datechooser.beans.DateChooserCombo();

        setBackground(new java.awt.Color(255, 255, 255));

        kodeT.setHint("TRXJ0001");
        kodeT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kodeTActionPerformed(evt);
            }
        });

        kodeP.setHint("MA010001");

        namaP.setHint("CHITATO");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("ID Transaksi");
        jLabel1.setMaximumSize(new java.awt.Dimension(45, 16));
        jLabel1.setMinimumSize(new java.awt.Dimension(45, 16));
        jLabel1.setPreferredSize(new java.awt.Dimension(45, 16));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Kode Produk");
        jLabel2.setMaximumSize(new java.awt.Dimension(45, 16));
        jLabel2.setMinimumSize(new java.awt.Dimension(45, 16));
        jLabel2.setPreferredSize(new java.awt.Dimension(45, 16));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Nama Produk");
        jLabel3.setMaximumSize(new java.awt.Dimension(45, 16));
        jLabel3.setMinimumSize(new java.awt.Dimension(45, 16));
        jLabel3.setPreferredSize(new java.awt.Dimension(45, 16));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Jumlah");
        jLabel4.setMaximumSize(new java.awt.Dimension(45, 16));
        jLabel4.setMinimumSize(new java.awt.Dimension(45, 16));
        jLabel4.setPreferredSize(new java.awt.Dimension(45, 16));

        jmlP.setHint("10");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Harga");
        jLabel5.setMaximumSize(new java.awt.Dimension(45, 16));
        jLabel5.setMinimumSize(new java.awt.Dimension(45, 16));
        jLabel5.setPreferredSize(new java.awt.Dimension(45, 16));

        hargaP.setHint("1000");

        btnTambah.setBackground(new java.awt.Color(51, 255, 51));
        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        tblJual.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Transaksi", "Tanggal", "Kode Produk", "Nama Produk", "Jumlah", "Harga"
            }
        ));
        jScrollPane1.setViewportView(tblJual);

        btnSimpan.setBackground(new java.awt.Color(51, 255, 51));
        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        ttl_Bayar.setForeground(new java.awt.Color(255, 153, 204));
        ttl_Bayar.setDisabledTextColor(new java.awt.Color(255, 153, 204));
        ttl_Bayar.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        ttl_Bayar.setHint("100.000");
        ttl_Bayar.setSelectionColor(new java.awt.Color(255, 153, 255));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Bayar");
        jLabel6.setMaximumSize(new java.awt.Dimension(45, 16));
        jLabel6.setMinimumSize(new java.awt.Dimension(45, 16));
        jLabel6.setPreferredSize(new java.awt.Dimension(45, 16));

        tf_Bayar.setHint("10000");

        tf_Kembali.setHint("5000");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Kembali");
        jLabel7.setMaximumSize(new java.awt.Dimension(45, 16));
        jLabel7.setMinimumSize(new java.awt.Dimension(45, 16));
        jLabel7.setPreferredSize(new java.awt.Dimension(45, 16));

        btnBayar.setBackground(new java.awt.Color(51, 255, 51));
        btnBayar.setText("Bayar");
        btnBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBayarActionPerformed(evt);
            }
        });

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Tanggal");

        btnPanggil.setBackground(new java.awt.Color(51, 255, 51));
        btnPanggil.setText(". . .");
        btnPanggil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPanggilActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ttl_Bayar, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tf_Bayar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tf_Kembali, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(namaP, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jmlP, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(hargaP, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(38, 38, 38)
                                    .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(kodeT, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(kodeP, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(btnPanggil, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(33, 33, 33)
                                            .addComponent(cbDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(15, 15, 15))))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 885, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kodeT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(kodeP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(btnPanggil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namaP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jmlP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hargaP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_Bayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_Kembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(ttl_Bayar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(101, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void kodeTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kodeTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kodeTActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        String idTransaksi = kodeT.getText();
        String kodeProduk = kodeP.getText();
        String namaProduk = namaP.getText();
        String jmlh = jmlP.getText();
        int jumlah = Integer.parseInt(jmlh);
        String harga = hargaP.getText();
        double hrg = Double.parseDouble(harga);
        double total = hrg * jumlah;
        String tanggal = cbDate.getText();
        int productId = 0;
        try {
            String sqlSelect = "SELECT product_id FROM produk ORDER BY product_id LIMIT 1";
            PreparedStatement pstSelect = conn.prepareStatement(sqlSelect);
            ResultSet rs = pstSelect.executeQuery();
            if (rs.next()) {
                productId = rs.getInt("product_id");
            }
            System.out.println("Product ID: " + productId); // Debug: Tampilkan product_id untuk memastikan
        } catch (SQLException e) {
            e.printStackTrace(); // Debug jika ada error
        }

        try {
            // Mulai transaksi
            conn.setAutoCommit(false); // Matikan auto-commit untuk kontrol transaksi manual

            // Query untuk memasukkan data ke pembelian
            String insertPembelian = "INSERT INTO sales (user_id, product_id, quantity, total_price, sales_date) "
                    + "VALUES (?, ?, ?, ?, CURRENT_DATE)";
            try (PreparedStatement pstInsert = conn.prepareStatement(insertPembelian)) {
                pstInsert.setInt(1, 1); // user_id
                pstInsert.setInt(2, productId); // product_id
                pstInsert.setInt(3, jumlah); // quantity
                pstInsert.setDouble(4, total); // total_price
                pstInsert.executeUpdate();
            }

            // Query untuk memperbarui stok produk
            String updateStok = "UPDATE produk SET stock = stock - ? WHERE product_id = ?";
            try (PreparedStatement pstUpdate = conn.prepareStatement(updateStok)) {
                pstUpdate.setInt(1, jumlah); // jumlah yang ingin ditambahkan
                pstUpdate.setInt(2, productId); // product_id
                pstUpdate.executeUpdate();
            }

            // Commit transaksi jika tidak ada error
            conn.commit();
            JOptionPane.showMessageDialog(this, "Berhasil ditambahkan");

        } catch (SQLException e) {
            try {
                conn.rollback(); // Rollback transaksi jika terjadi error
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace(); // Jika rollback gagal
            }
            JOptionPane.showMessageDialog(this, "Gagal terhubung ke database: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace(); // Debug jika ada error
        } finally {
            try {
                conn.setAutoCommit(true); // Kembali ke auto-commit setelah transaksi selesai
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (!kodeP.getText().isEmpty() && !namaP.getText().isEmpty() && !jmlP.getText().isEmpty() && !hargaP.getText().isEmpty()) {
            // Menambahkan data ke table jika form valid
            model = (DefaultTableModel) tblJual.getModel();
            model.addRow(new Object[]{idTransaksi, tanggal, kodeProduk, namaProduk, jumlah, harga});
            clearForm();
        } else {
            JOptionPane.showMessageDialog(this, "Semua field harus diisi!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBayarActionPerformed
        try {
            // Ambil total bayar dari ttl_Bayar
            double totalBayar = Double.parseDouble(ttl_Bayar.getText());

            // Ambil jumlah bayar dari tf_Bayar
            double jumlahBayar = Double.parseDouble(tf_Bayar.getText());

            // Hitung kembalian
            double kembalian = jumlahBayar - totalBayar;

            // Tampilkan kembalian di tf_Kembali
            tf_Kembali.setText(String.valueOf(kembalian));

            // Jika kembalian negatif, tampilkan pesan kesalahan
            if (kembalian < 0) {
                JOptionPane.showMessageDialog(this, "Jumlah bayar tidak cukup!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // Tampilkan dialog dengan kembalian
                JOptionPane.showMessageDialog(this, "Kembalian Anda: Rp " + String.format("%.2f", kembalian) + "\nTerima kasih telah berbelanja!", "Kembalian", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NumberFormatException e) {
            // Tangani kesalahan konversi jika diperlukan
            JOptionPane.showMessageDialog(this, "Format jumlah bayar tidak valid!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBayarActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        DefaultTableModel model = (DefaultTableModel) tblJual.getModel();
        double totalBayar = 0;

        // Iterasi melalui semua baris di tabel
        for (int i = 0; i < model.getRowCount(); i++) {
            // Ambil nilai dari kolom "Jumlah" dan "Harga"
            Object jumlahObj = model.getValueAt(i, 4); // Kolom 4 adalah "Jumlah"
            Object hargaObj = model.getValueAt(i, 5); // Kolom 5 adalah "Harga"

            // Pastikan nilai tidak null sebelum mengonversi
            if (jumlahObj != null && hargaObj != null) {
                try {
                    int jumlah = Integer.parseInt(jumlahObj.toString());
                    double harga = Double.parseDouble(hargaObj.toString());

                    // Hitung total untuk baris ini
                    totalBayar += jumlah * harga;
                } catch (NumberFormatException e) {
                    // Tangani kesalahan konversi jika diperlukan
                    JOptionPane.showMessageDialog(this, "Format jumlah atau harga tidak valid di baris " + (i + 1), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        // Tampilkan total di text field ttl_Bayar
        ttl_Bayar.setText(String.valueOf(totalBayar));

    }//GEN-LAST:event_btnSimpanActionPerformed
    private void ambilData() {
        frameJual getProduk = new frameJual();
        getProduk.setVisible(true);
        getProduk.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                List<String[]> dataTerpilihList = getProduk.getselectedDataProduk();
                if (!dataTerpilihList.isEmpty()) {
                    for (String[] data : dataTerpilihList) {
                        kodeP.setText(data[0]);
                        namaP.setText(data[1]);
                        hargaP.setText(data[2]);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Input kosong!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

    }
    private void btnPanggilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPanggilActionPerformed
        ambilData();
    }//GEN-LAST:event_btnPanggilActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button btnBayar;
    private swing.Button btnPanggil;
    private swing.Button btnSimpan;
    private swing.Button btnTambah;
    private datechooser.beans.DateChooserCombo cbDate;
    private swing.TextField hargaP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private swing.TextField jmlP;
    private swing.TextField kodeP;
    private swing.TextField kodeT;
    private swing.TextField namaP;
    private javax.swing.JTable tblJual;
    private swing.TextField tf_Bayar;
    private swing.TextField tf_Kembali;
    private swing.TextField ttl_Bayar;
    // End of variables declaration//GEN-END:variables
}
