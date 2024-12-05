package form;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Form_Laporan extends javax.swing.JPanel {

    public Form_Laporan() {
        initComponents();
        initListeners();
    }

    // Metode untuk menambahkan listener ke tombol pilih
    private void initListeners() {
        btnPilih.addActionListener(e -> handlePilih());
    }

    // Logika tombol pilih
    private void handlePilih() {
        String selectedReport = (String) cbLaporan.getSelectedItem();

        // Sembunyikan semua panel terlebih dahulu
        lapPn.setVisible(false);
        lapPj.setVisible(false);

        switch (selectedReport) {
            case "Laporan Penjualan":
                loadLaporanPenjualan();
                lapPj.setVisible(true);
                break;

            case "Laporan Pembelian":
                loadLaporanPembelian();
                lapPn.setVisible(true);
                break;

            default:
                JOptionPane.showMessageDialog(this, "Pilih jenis laporan terlebih dahulu!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
    }

    // Metode untuk memuat data laporan penjualan (data dummy)
    private void loadLaporanPenjualan() {
        DefaultTableModel model = (DefaultTableModel) tblPj.getModel();
        model.setRowCount(0); // Hapus data lama

        // Tambahkan data dummy
        Object[][] dataPenjualan = {
            {"PJ001", "SN001", "2024-01-01", 10, 50000, "Supplier A"},
            {"PJ002", "SN002", "2024-01-02", 20, 100000, "Supplier B"},
            {"PJ003", "SN003", "2024-01-03", 15, 75000, "Supplier C"}
        };

        for (Object[] row : dataPenjualan) {
            model.addRow(row);
        }
    }

    // Metode untuk memuat data laporan pembelian (data dummy)
    private void loadLaporanPembelian() {
        DefaultTableModel model = (DefaultTableModel) tblPn.getModel();
        model.setRowCount(0); // Hapus data lama

        // Tambahkan data dummy
        Object[][] dataPembelian = {
            {"PB001", "SN001", 30, "2024-01-01", 150000},
            {"PB002", "SN002", 25, "2024-01-02", 125000},
            {"PB003", "SN003", 40, "2024-01-03", 200000}
        };

        for (Object[] row : dataPembelian) {
            model.addRow(row);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnLaporan = new javax.swing.JPanel();
        pnTampil = new javax.swing.JPanel();
        lapPn = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPn = new javax.swing.JTable();
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

        lapPn.setBackground(new java.awt.Color(237, 237, 237));

        tblPn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Transaksi", "Kode Barang", "Jumlah", "Tanggal", "Total Harga"
            }
        ));
        jScrollPane2.setViewportView(tblPn);

        javax.swing.GroupLayout lapPnLayout = new javax.swing.GroupLayout(lapPn);
        lapPn.setLayout(lapPnLayout);
        lapPnLayout.setHorizontalGroup(
            lapPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lapPnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 870, Short.MAX_VALUE)
                .addContainerGap())
        );
        lapPnLayout.setVerticalGroup(
            lapPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lapPnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnTampil.add(lapPn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 106, -1, 430));

        lapPj.setBackground(new java.awt.Color(237, 237, 237));

        tblPj.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID Transaksi", "Kode Barang", "Tanggal", "Jumlah", "Total Harga", "Supplier"
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

        cbLaporan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "== Pilih Jenis Laporan ==", "Laporan Penjualan", "Laporan Pembelian" }));
        pnTampil.add(cbLaporan, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 193, 30));

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel1.setText("Pilih Jenis Laporan :");
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
    private javax.swing.JPanel lapPj;
    private javax.swing.JPanel lapPn;
    private javax.swing.JPanel pnLaporan;
    private javax.swing.JPanel pnTampil;
    private javax.swing.JTable tblPj;
    private javax.swing.JTable tblPn;
    // End of variables declaration//GEN-END:variables
}
