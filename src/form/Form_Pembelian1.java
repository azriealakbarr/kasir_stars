package form;

import db.db_connection;
import frame.frameBeli;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import user.PenggunaLogin;

public class Form_Pembelian1 extends javax.swing.JPanel {

    private DefaultTableModel model;
    private boolean isSaving = false;
    private Connection conn = db.db_connection.connect();

    public Form_Pembelian1() {
        initComponents();
    }

    public void clearForm() {
        kodeT.setText("");
        kodeS.setText("");
        kodeP.setText("");
        namaP.setText("");
        hargaP.setText("");
        jmlP.setText("");
        idP.setText("");
        tf_Bayar.setText("");
        tf_Kembali.setText("");
        ttl_Bayar.setText("");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kodeP = new swing.TextField();
        namaP = new swing.TextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jmlP = new swing.TextField();
        jLabel5 = new javax.swing.JLabel();
        hargaP = new swing.TextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBeli = new javax.swing.JTable();
        btnSimpan = new swing.Button();
        ttl_Bayar = new swing.TextField();
        jLabel6 = new javax.swing.JLabel();
        tf_Bayar = new swing.TextField();
        tf_Kembali = new swing.TextField();
        jLabel7 = new javax.swing.JLabel();
        btnBayar = new swing.Button();
        btnPanggil = new swing.Button();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        kodeT = new swing.TextField();
        jPanel2 = new javax.swing.JPanel();
        kodeS = new swing.TextField();
        jLabel10 = new javax.swing.JLabel();
        btnTambah = new swing.Button();
        cbDate = new datechooser.beans.DateChooserCombo();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        idP = new swing.TextField();

        setBackground(new java.awt.Color(255, 255, 255));

        kodeP.setHint("MA010001");

        namaP.setHint("CHITATO");
        namaP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaPActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("ID Pembelian");
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
        jLabel4.setText("Stock");
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

        tblBeli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Pembelian", "Tanggal", "ID Produk", "Kode Produk", "Nama Produk", "Supplier", "Jumlah", "Harga"
            }
        ));
        jScrollPane1.setViewportView(tblBeli);

        btnSimpan.setBackground(new java.awt.Color(51, 255, 51));
        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        ttl_Bayar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        ttl_Bayar.setForeground(new java.awt.Color(255, 153, 204));
        ttl_Bayar.setDisabledTextColor(new java.awt.Color(255, 153, 204));
        ttl_Bayar.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        ttl_Bayar.setHint(" 100.000");
        ttl_Bayar.setSelectionColor(new java.awt.Color(255, 153, 255));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Bayar");
        jLabel6.setMaximumSize(new java.awt.Dimension(45, 16));
        jLabel6.setMinimumSize(new java.awt.Dimension(45, 16));
        jLabel6.setPreferredSize(new java.awt.Dimension(45, 16));

        tf_Bayar.setHint("10000");
        tf_Bayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_BayarActionPerformed(evt);
            }
        });

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

        btnPanggil.setBackground(new java.awt.Color(51, 255, 51));
        btnPanggil.setText(". . .");
        btnPanggil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPanggilActionPerformed(evt);
            }
        });

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Supplier");
        jLabel9.setMaximumSize(new java.awt.Dimension(45, 16));
        jLabel9.setMinimumSize(new java.awt.Dimension(45, 16));
        jLabel9.setPreferredSize(new java.awt.Dimension(45, 16));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.setForeground(new java.awt.Color(204, 204, 204));

        kodeT.setHint("TRXJ0001");
        kodeT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kodeTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(kodeT, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(kodeT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        kodeS.setHint("TRXJ0001");
        kodeS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kodeSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(kodeS, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(kodeS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Total");
        jLabel10.setMaximumSize(new java.awt.Dimension(45, 16));
        jLabel10.setMinimumSize(new java.awt.Dimension(45, 16));
        jLabel10.setPreferredSize(new java.awt.Dimension(45, 16));

        btnTambah.setBackground(new java.awt.Color(51, 255, 51));
        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Tanggal");
        jLabel8.setMaximumSize(new java.awt.Dimension(45, 16));
        jLabel8.setMinimumSize(new java.awt.Dimension(45, 16));
        jLabel8.setPreferredSize(new java.awt.Dimension(45, 16));

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("ID Produk");
        jLabel11.setMaximumSize(new java.awt.Dimension(45, 16));
        jLabel11.setMinimumSize(new java.awt.Dimension(45, 16));
        jLabel11.setPreferredSize(new java.awt.Dimension(45, 16));

        idP.setHint("10");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(130, 130, 130)
                                .addComponent(kodeP, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(btnPanggil, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(77, 77, 77)
                                            .addComponent(idP, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(91, 91, 91)
                                        .addComponent(namaP, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(133, 133, 133)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(63, 63, 63)
                                        .addComponent(hargaP, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(55, 55, 55)
                                        .addComponent(jmlP, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(ttl_Bayar, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(408, 408, 408)
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
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 885, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ttl_Bayar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(idP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kodeP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(namaP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPanggil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hargaP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jmlP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_Bayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_Kembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(81, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void kodeTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kodeTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kodeTActionPerformed

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
            clearForm();
            model.setRowCount(0);

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
        model = (DefaultTableModel) tblBeli.getModel();
        double totalBayar = 0;

        for (int i = 0; i < model.getRowCount(); i++) {
            Object jumlahObj = model.getValueAt(i, 6);
            Object hargaObj = model.getValueAt(i, 7);

            if (jumlahObj == null || hargaObj == null || jumlahObj.toString().isEmpty() || hargaObj.toString().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Jumlah atau harga kosong di baris " + (i + 1), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                int jumlah = Integer.parseInt(jumlahObj.toString());
                double harga = Double.parseDouble(hargaObj.toString());
                totalBayar += jumlah * harga;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Format jumlah atau harga tidak valid di baris " + (i + 1), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        ttl_Bayar.setText(String.valueOf(totalBayar));
    }//GEN-LAST:event_btnSimpanActionPerformed
    private void ambilData() {
        frameBeli getProduk = new frameBeli();
        getProduk.setVisible(true);
        getProduk.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                List<String[]> dataTerpilihList = getProduk.getselectedDataProduk();
                if (!dataTerpilihList.isEmpty()) {
                    for (String[] data : dataTerpilihList) {
                        idP.setText(data[0]);
                        kodeP.setText(data[1]);
                        namaP.setText(data[2]);
                        hargaP.setText(data[3]);
                        
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

    private void kodeSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kodeSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kodeSActionPerformed

    private void namaPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaPActionPerformed

    private void tf_BayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_BayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_BayarActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        String idPembelian = kodeT.getText();
        String Supplier = kodeS.getText();
        String kodeProduk = kodeP.getText();
        String proId = idP.getText();
        Integer productId = Integer.parseInt(proId);
        String namaProduk = namaP.getText();
        String jmlh = jmlP.getText();
        int jumlah = Integer.parseInt(jmlh);
        String harga = hargaP.getText();
        
        // Validasi input jumlah dan harga
        if (jmlh.isEmpty() || harga.isEmpty() || !jmlh.matches("\\d+") || !harga.matches("\\d+(\\.\\d+)?")) {
            JOptionPane.showMessageDialog(this, "Input jumlah atau harga tidak valid!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        double hrg = Double.parseDouble(harga);
        double total = hrg * jumlah;
        String tanggal = cbDate.getText();
        
        try {
            // Mulai transaksi
            conn.setAutoCommit(false); // Matikan auto-commit untuk kontrol transaksi manual

            // Query untuk memasukkan data ke pembelian
            String insertPembelian = "INSERT INTO pembelian (user_id, product_id, quantity, supplier, total_price, purchase_date) "
                    + "VALUES (?, ?, ?, ?, ?, CURRENT_DATE)";
            try (PreparedStatement pstInsert = conn.prepareStatement(insertPembelian)) {
                pstInsert.setInt(1, 1); // user_id
                pstInsert.setInt(2, productId); // product_id
                pstInsert.setInt(3, jumlah); // quantity
                pstInsert.setString(4, Supplier); // supplier
                pstInsert.setDouble(5, total); // total_price
                pstInsert.executeUpdate();
            }

            // Query untuk memperbarui stok produk
            String updateStok = "UPDATE produk SET stock = stock + ? WHERE product_id = ?";
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

        if (!idP.getText().isEmpty() && !kodeS.getText().isEmpty() && !kodeP.getText().isEmpty() && !namaP.getText().isEmpty() && !jmlP.getText().isEmpty() && !hargaP.getText().isEmpty()) {
            // Menambahkan data ke table jika form valid
            model = (DefaultTableModel) tblBeli.getModel();
            model.addRow(new Object[]{idPembelian, Supplier, productId, tanggal, kodeProduk, namaProduk, jumlah, harga});
            clearForm();
        } else {
            JOptionPane.showMessageDialog(this, "Semua field harus diisi!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnTambahActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button btnBayar;
    private swing.Button btnPanggil;
    private swing.Button btnSimpan;
    private swing.Button btnTambah;
    private datechooser.beans.DateChooserCombo cbDate;
    private swing.TextField hargaP;
    private swing.TextField idP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private swing.TextField jmlP;
    private swing.TextField kodeP;
    private swing.TextField kodeS;
    private swing.TextField kodeT;
    private swing.TextField namaP;
    private javax.swing.JTable tblBeli;
    private swing.TextField tf_Bayar;
    private swing.TextField tf_Kembali;
    private swing.TextField ttl_Bayar;
    // End of variables declaration//GEN-END:variables
}
