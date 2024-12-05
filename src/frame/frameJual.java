package frame;

import db.db_connection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frameJual extends javax.swing.JFrame {
    
private DefaultTableModel model;
private Connection conn = db_connection.connect(); 
    
    public frameJual() {
        initComponents();
        ambilProduk();
        model = (DefaultTableModel) tbl_produk.getModel();
    }

    public void ambilProduk() {
        model = new DefaultTableModel(new Object[]{"Kode Produk", "Nama Produk", "Harga"},0);
        tbl_produk.setModel(model);
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM produk")) {

            while (rs.next()) {
                Object[] row = {
                    rs.getString("product_code"),
                    rs.getString("product_name"),
                    rs.getDouble("price_sales")
                };
                model.addRow(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        }
    
    public List<String[]> getselectedDataProduk() {
        List<String[]> dataTerpilih = new ArrayList<>();
        int[] selectedRows = tbl_produk.getSelectedRows();
        
        for (int row : selectedRows){
            String[] data = new String[3];
            data[0] = model.getValueAt(row, 0).toString();
            data[1] = model.getValueAt(row, 1).toString();
            data[2] = model.getValueAt(row, 2).toString();
            dataTerpilih.add(data);
        }
        return dataTerpilih;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_produk = new javax.swing.JTable();
        btnEnter = new swing.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbl_produk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode", "Nama", "Harga"
            }
        ));
        jScrollPane1.setViewportView(tbl_produk);

        btnEnter.setText("Enter");
        btnEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEnter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnterActionPerformed
       List<String[]>selectedData = getselectedDataProduk();
        if (!selectedData.isEmpty()) {
            dispose();
        }else {
            JOptionPane.showMessageDialog(this, "Pilih produk terlebih dahulu!");
        }
    }//GEN-LAST:event_btnEnterActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frameJual().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button btnEnter;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_produk;
    // End of variables declaration//GEN-END:variables
}
