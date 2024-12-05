package form;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import db.db_connection;
import java.awt.event.*;

public class Form_Pembelian extends javax.swing.JPanel {

    private Connection conn = db_connection.connect(); 
    private PreparedStatement pst;
    private ResultSet rs;

    public Form_Pembelian() {
        initComponents();
        populateKodeProduk();
        setupTable();
    }


    private void populateKodeProduk() {
        try {
            String sql = "SELECT product_code FROM produk";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                txt_kodeproduk.addItem(rs.getString("product_code"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error mengambil kode produk: " + ex.getMessage());
        }
    }

    private void setupTable() {
        DefaultTableModel model = (DefaultTableModel) Table.getModel();
        model.setColumnIdentifiers(new Object[]{"No", "ID Pembelian", "Kode Produk", "Nama Produk", "Harga Beli", "Stock", "Total"});
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txt_batal = new swing.Button();
        txt_hapus = new swing.Button();
        txt_perbaraui = new swing.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        txt_kodeproduk = new javax.swing.JComboBox<>();
        txt_namaproduk = new swing.TextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_hargaproduk = new swing.TextField();
        txt_stock = new swing.TextField();
        jPanel2 = new javax.swing.JPanel();
        txt_idpembelian = new swing.TextField();
        jPanel3 = new javax.swing.JPanel();
        txt_supplier = new swing.TextField();
        jPanel4 = new javax.swing.JPanel();
        txt_totalsemua = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Id_Pembelian");

        jLabel2.setText("Supplier");

        jLabel3.setText("Total");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        txt_batal.setBackground(new java.awt.Color(153, 153, 255));
        txt_batal.setText("Batal");

        txt_hapus.setBackground(new java.awt.Color(153, 153, 255));
        txt_hapus.setText("Hapus");

        txt_perbaraui.setBackground(new java.awt.Color(153, 153, 255));
        txt_perbaraui.setText("Perbarui");
        txt_perbaraui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_perbarauiActionPerformed(evt);
            }
        });

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "Id_Pembelian", "Kode Produk", "Nama Produk", "Harga Beli", "Stock", "Total"
            }
        ));
        jScrollPane1.setViewportView(Table);

        txt_kodeproduk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        txt_kodeproduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_kodeprodukActionPerformed(evt);
            }
        });

        txt_namaproduk.setHint("Nama Produk");
        txt_namaproduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_namaprodukActionPerformed(evt);
            }
        });

        jLabel4.setText("Kode Produk");

        jLabel5.setText("Nama Produk");

        jLabel6.setText("Harga Beli");

        jLabel7.setText("Stock");

        txt_hargaproduk.setHint("10.000");
        txt_hargaproduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_hargaprodukActionPerformed(evt);
            }
        });

        txt_stock.setHint("1");
        txt_stock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_stockActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_kodeproduk, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_namaproduk, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_hargaproduk, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_stock, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_perbaraui, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(txt_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(txt_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 872, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(38, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txt_hargaproduk, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txt_stock, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(txt_kodeproduk, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_namaproduk, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(35, 35, 35)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_perbaraui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_batal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        txt_idpembelian.setHint("T1");
        txt_idpembelian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idpembelianActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(txt_idpembelian, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(txt_idpembelian, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        txt_supplier.setHint("Nama Supplier");
        txt_supplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_supplierActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(txt_supplier, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(txt_supplier, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        txt_totalsemua.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        txt_totalsemua.setText("Rp. 0,000,00");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_totalsemua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_totalsemua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(83, 83, 83)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(115, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_idpembelianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idpembelianActionPerformed
    PreparedStatement pst = null;
    ResultSet rs = null;
    try {
        String sql = "SELECT MAX(purchase_id) FROM pembelian";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        if (rs.next()) {
            int id = rs.getInt(1) + 1;
            txt_idpembelian.setText(String.valueOf(id));
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error memperbarui data: " + e.getMessage());
    } finally {
        try {
            if (rs != null) rs.close();
            if (pst != null) pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

    private void simpanData() {
        try {

            String sql = "INSERT INTO pembelian (purchase_id, product_code, quantity, total_price) VALUES (?, ?, ?, ?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1, txt_idpembelian.getText());
            pst.setString(2, (String) txt_kodeproduk.getSelectedItem());
            pst.setInt(3, Integer.parseInt(txt_stock.getText()));
            pst.setInt(4, Integer.parseInt(txt_hargaproduk.getText()) * Integer.parseInt(txt_stock.getText()));
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data Pembelian berhasil disimpan!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error menyimpan data: " + ex.getMessage());
        }
    }

    private void hapusData() {
        try {
            int row = Table.getSelectedRow();
            if (row != -1) {
                String idPembelian = (String) Table.getValueAt(row, 1);

                String sql = "DELETE FROM pembelian WHERE purchase_id = ?";
                pst = conn.prepareStatement(sql);
                pst.setString(1, idPembelian);
                pst.executeUpdate();

                DefaultTableModel model = (DefaultTableModel) Table.getModel();
                model.removeRow(row);

                JOptionPane.showMessageDialog(this, "Data berhasil dihapus!");
                updateTotal();
            } else {
                JOptionPane.showMessageDialog(this, "Pilih data yang akan dihapus!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error menghapus data: " + ex.getMessage());
        }
    }

    private void batal() {

        txt_idpembelian.setText("");
        txt_kodeproduk.setSelectedIndex(0);
        txt_namaproduk.setText("");
        txt_hargaproduk.setText("");
        txt_stock.setText("");
        txt_totalsemua.setText("Total Semua: 0");

        DefaultTableModel model = (DefaultTableModel) Table.getModel();
        model.setRowCount(0);
    }

    private void txt_perbaruiActionPerformed(ActionEvent evt) {
        try {
            int row = Table.getSelectedRow();
            if (row != -1) {
                String idPembelian = (String) Table.getValueAt(row, 1);
                String kodeProduk = (String) Table.getValueAt(row, 2);
                int stock = Integer.parseInt(txt_stock.getText());
                int hargaBeli = Integer.parseInt(txt_hargaproduk.getText());
                int total = hargaBeli * stock;

                String sql = "UPDATE pembelian SET product_code = ?, quantity = ?, total_price = ? WHERE purchase_id = ?";
                pst = conn.prepareStatement(sql);
                pst.setString(1, kodeProduk);
                pst.setInt(2, stock);
                pst.setInt(3, total);
                pst.setString(4, idPembelian);
                pst.executeUpdate();

                DefaultTableModel model = (DefaultTableModel) Table.getModel();
                model.setValueAt(kodeProduk, row, 2);
                model.setValueAt(txt_namaproduk.getText(), row, 3);
                model.setValueAt(hargaBeli, row, 4);
                model.setValueAt(stock, row, 5);
                model.setValueAt(total, row, 6);

                JOptionPane.showMessageDialog(this, "Data berhasil diperbarui!");
                updateTotal();
            } else {
                JOptionPane.showMessageDialog(this, "Pilih data yang akan diperbarui!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error memperbarui data: " + ex.getMessage());
        }
     }//GEN-LAST:event_txt_idpembelianActionPerformed

    private void txt_perbarauiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_perbarauiActionPerformed
    }

    private void txt_hapusActionPerformed(ActionEvent evt) {
        hapusData();
     }//GEN-LAST:event_txt_perbarauiActionPerformed

    private void txt_supplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_supplierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_supplierActionPerformed

    private void txt_namaprodukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_namaprodukActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_namaprodukActionPerformed

    private void txt_kodeprodukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_kodeprodukActionPerformed
        String kodeProduk = (String) txt_kodeproduk.getSelectedItem();
        try {
            String sql = "SELECT product_name, price_purchase FROM produk WHERE product_code = ?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, kodeProduk);
            rs = pst.executeQuery();
            if (rs.next()) {
                txt_namaproduk.setText(rs.getString("nama_produk"));
                txt_hargaproduk.setText(rs.getString("harga_beli"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error mengambil data produk: " + ex.getMessage());
}    }//GEN-LAST:event_txt_kodeprodukActionPerformed

    private void txt_hargaprodukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_hargaprodukActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_hargaprodukActionPerformed

    private void txt_stockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_stockActionPerformed
        try {
            int hargaBeli = Integer.parseInt(txt_hargaproduk.getText());
            int stock = Integer.parseInt(txt_stock.getText());
            int total = hargaBeli * stock;
            // Menampilkan hasil perhitungan total pada kolom Total
            DefaultTableModel model = (DefaultTableModel) Table.getModel();
            model.addRow(new Object[]{
                model.getRowCount() + 1,
                txt_idpembelian.getText(),
                txt_kodeproduk.getSelectedItem(),
                txt_namaproduk.getText(),
                hargaBeli,
                stock,
                total
            });
            updateTotal();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Harga atau Stock tidak valid!");
        }    }//GEN-LAST:event_txt_stockActionPerformed

    private void updateTotal() {
        DefaultTableModel model = (DefaultTableModel) Table.getModel();
        int totalSemua = 0;
        for (int i = 0; i < model.getRowCount(); i++) {
            totalSemua += (int) model.getValueAt(i, 6);
        }
        txt_totalsemua.setText("Total Semua: " + totalSemua);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private swing.Button txt_batal;
    private swing.Button txt_hapus;
    private swing.TextField txt_hargaproduk;
    private swing.TextField txt_idpembelian;
    private javax.swing.JComboBox<String> txt_kodeproduk;
    private swing.TextField txt_namaproduk;
    private swing.Button txt_perbaraui;
    private swing.TextField txt_stock;
    private swing.TextField txt_supplier;
    private javax.swing.JLabel txt_totalsemua;
    // End of variables declaration//GEN-END:variables
}
