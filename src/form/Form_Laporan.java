package form;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Form_Laporan extends javax.swing.JPanel {

    private final Connection conn = db.db_connection.connect();

    public Form_Laporan() {
        initComponents();
        initListeners();
        DefaultTableModel modelPb = new DefaultTableModel(
                new Object[][]{},
                new String[]{"Product ID", "Product Code", "Product Name", "Purchase Date", "Quantity", "Total Price", "Supplier"}
        );
        tblPb.setModel(modelPb);

        DefaultTableModel modelPj = new DefaultTableModel(
                new Object[][]{},
                new String[]{"Product ID", "Product Code", "Product Name", "Sales Date", "Quantity", "Total Price"}
        );
        tblPj.setModel(modelPj);

    }

    // Metode untuk menambahkan listener ke tombol pilih
    private void initListeners() {
        btnPilih.addActionListener(e -> handlePilih());
    }

    // Logika tombol pilih
    private void handlePilih() {
        String selectedReport = (String) cbLaporan.getSelectedItem();

        // Sembunyikan semua panel terlebih dahulu
        lapPb.setVisible(false);
        lapPj.setVisible(false);

        switch (selectedReport) {
            case "Transaksi Penjualan":
                loadLaporanPenjualan();
                lapPj.setVisible(true);
                break;

            case "Transaksi Pembelian":
                loadLaporanPembelian();
                lapPb.setVisible(true);
                break;

            default:
                JOptionPane.showMessageDialog(this, "Pilih jenis laporan terlebih dahulu!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
    }

    // Metode untuk memuat data laporan penjualan (data dummy)
    private void loadLaporanPenjualan() {
        DefaultTableModel model = (DefaultTableModel) tblPj.getModel();
        model.setRowCount(0); // Hapus data lama

        String query = "SELECT sales.product_id, produk.product_code, produk.product_name, sales.sales_date, sales.quantity, sales.total_price "
                + "FROM sales "
                + "INNER JOIN produk ON sales.product_id = produk.product_id";

        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Object[] row = {
                    rs.getString("product_id"),
                    rs.getString("product_code"),
                    rs.getString("product_name"),
                    rs.getDate("sales_date"),
                    rs.getInt("quantity"),
                    rs.getDouble("total_price")
                };
                model.addRow(row);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading sales data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Metode untuk memuat data laporan pembelian (data dummy)
    private void loadLaporanPembelian() {
        DefaultTableModel model = (DefaultTableModel) tblPb.getModel();
        model.setRowCount(0); // Hapus data lama

        String query = "SELECT pembelian.product_id, produk.product_code, produk.product_name, pembelian.purchase_date, pembelian.quantity, pembelian.total_price, pembelian.supplier "
                + "FROM pembelian "
                + "INNER JOIN produk ON pembelian.product_id = produk.product_id";

        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Object[] row = {
                    rs.getString("product_id"),
                    rs.getString("product_code"),
                    rs.getString("product_name"),
                    rs.getDate("purchase_date"),
                    rs.getInt("quantity"),
                    rs.getDouble("total_price"),
                    rs.getString("supplier")
                };
                model.addRow(row);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading purchase data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnLaporan = new javax.swing.JPanel();
        pnTampil = new javax.swing.JPanel();
        lapPb = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPb = new javax.swing.JTable();
        lapPj = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPj = new javax.swing.JTable();
        btnPilih = new swing.Button();
        cbLaporan = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(941, 634));

        pnLaporan.setBackground(new java.awt.Color(255, 255, 255));

        pnTampil.setBackground(new java.awt.Color(255, 255, 255));
        pnTampil.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lapPb.setBackground(new java.awt.Color(237, 237, 237));

        tblPb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Product ID", "Kode Barang", "Nama Barang", "Jumlah", "Total Harga", "Supplier", "Tanggal"
            }
        ));
        jScrollPane2.setViewportView(tblPb);

        javax.swing.GroupLayout lapPbLayout = new javax.swing.GroupLayout(lapPb);
        lapPb.setLayout(lapPbLayout);
        lapPbLayout.setHorizontalGroup(
            lapPbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lapPbLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 870, Short.MAX_VALUE)
                .addContainerGap())
        );
        lapPbLayout.setVerticalGroup(
            lapPbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lapPbLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnTampil.add(lapPb, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 106, -1, 430));

        lapPj.setBackground(new java.awt.Color(237, 237, 237));

        tblPj.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Product ID", "Kode Barang", "Nama Barang", "Jumlah", "Total Harga", "Tanggal"
            }
        ));
        jScrollPane1.setViewportView(tblPj);

        javax.swing.GroupLayout lapPjLayout = new javax.swing.GroupLayout(lapPj);
        lapPj.setLayout(lapPjLayout);
        lapPjLayout.setHorizontalGroup(
            lapPjLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lapPjLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 870, Short.MAX_VALUE)
                .addContainerGap())
        );
        lapPjLayout.setVerticalGroup(
            lapPjLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lapPjLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnTampil.add(lapPj, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 106, -1, 430));

        btnPilih.setBackground(new java.awt.Color(102, 102, 255));
        btnPilih.setText("Pilih");
        pnTampil.add(btnPilih, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, 70, 30));

        cbLaporan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "== Pilih Jenis Riwayat ==", "Transaksi Penjualan", "Transaksi Pembelian" }));
        pnTampil.add(cbLaporan, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 193, 30));

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel1.setText("Pilih Jenis Transaksi :");
        pnTampil.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, 30));

        javax.swing.GroupLayout pnLaporanLayout = new javax.swing.GroupLayout(pnLaporan);
        pnLaporan.setLayout(pnLaporanLayout);
        pnLaporanLayout.setHorizontalGroup(
            pnLaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnTampil, javax.swing.GroupLayout.DEFAULT_SIZE, 941, Short.MAX_VALUE)
        );
        pnLaporanLayout.setVerticalGroup(
            pnLaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnTampil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnLaporan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnLaporan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button btnPilih;
    private javax.swing.JComboBox<String> cbLaporan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel lapPb;
    private javax.swing.JPanel lapPj;
    private javax.swing.JPanel pnLaporan;
    private javax.swing.JPanel pnTampil;
    private javax.swing.JTable tblPb;
    private javax.swing.JTable tblPj;
    // End of variables declaration//GEN-END:variables
}
