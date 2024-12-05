package form;

import model.Model_Card;
import java.awt.Color;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import swing.Chart_Model;
import model.ModelChart_Value;

public class Form_Dashboard extends javax.swing.JPanel {

    DashboardData dashboardData = new DashboardData();
    ModelChart_Value data = new ModelChart_Value(); // Ganti dengan ModelChart_Value
    private final Connection conn = db.db_connection.connect();

    public Form_Dashboard() {
        initComponents();
        updateDashboardData();
        new Timer(5000, e -> updateDashboardData()).start();

        chart.start();
        chart.addLegend("Pembelian", new Color(245, 189, 135));
        chart.addLegend("Penjualan", new Color(135, 189, 245));
        chart.addLegend("Keuntungan", new Color(189, 135, 245));

        // Mulai dengan menampilkan data chart yang dinamis
        updateChartData();
    }

    public class DashboardData {
        
        public DashboardData() {
        }

        public ModelChart_Value getDashboardData() {
            ModelChart_Value data = new ModelChart_Value();

            try {
                // Ambil total pembelian
                String sqlPem = "SELECT SUM(total_price) FROM pembelian"; // Sesuaikan dengan query yang tepat
                PreparedStatement stmtPembelian = conn.prepareStatement(sqlPem);
                ResultSet rsPembelian = stmtPembelian.executeQuery();
                if (rsPembelian.next()) {
                    data.setTotalpem(rsPembelian.getDouble(1));
                    System.out.println("Total Pembelian: " + data.getTotalpem());
                }

                // Ambil total penjualan
                String sqlPen = "SELECT SUM(total_price) FROM sales"; // Sesuaikan dengan query yang tepat
                PreparedStatement stmtPenjualan = conn.prepareStatement(sqlPen);
                ResultSet rsPenjualan = stmtPenjualan.executeQuery();
                if (rsPenjualan.next()) {
                    data.setTotalpen(rsPenjualan.getDouble(1));
                    System.out.println("Total Penjualan: " + data.getTotalpen());
                }

                // Hitung keuntungan
                data.setKeuntungan(data.getTotalpen() - data.getTotalpem());
                System.out.println("Keuntungan: " + data.getKeuntungan());

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return data;
        }
    }

    private void updateDashboardData() {
        DashboardData dashboardData = new DashboardData();
        data = dashboardData.getDashboardData();

        card1.setData(new Model_Card(new ImageIcon(getClass().getResource("/icon/stock.png")), "Total Penjualan", "Rp " + data.getTotalpen()));
        card2.setData(new Model_Card(new ImageIcon(getClass().getResource("/icon/profit.png")), "Total Pembelian", "Rp " + data.getTotalpem()));
        card3.setData(new Model_Card(new ImageIcon(getClass().getResource("/icon/flag.png")), "Total Keuntungan", "Rp " + data.getKeuntungan()));
    }

    // Update chart dengan data yang didapatkan dari database
    private void updateChartData() {
        chart.clear();

        // Ambil data dari database dan tambahkan ke chart
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        double[] penjualanData = new double[12];
        double[] pembelianData = new double[12];
        double[] keuntunganData = new double[12];

        try {
            // Ambil data chart untuk setiap bulan
            for (int i = 0; i < months.length; i++) {
                String month = months[i];

                // Ambil data pembelian dan penjualan per bulan
                String sql = "SELECT SUM(total_price) FROM sales WHERE MONTH(date) = ?"; // Sesuaikan query dengan bulan
                PreparedStatement stmtPenjualan = conn.prepareStatement(sql);
                stmtPenjualan.setInt(1, i + 1);  // Set bulan
                ResultSet rsPenjualan = stmtPenjualan.executeQuery();
                if (rsPenjualan.next()) {
                    penjualanData[i] = rsPenjualan.getDouble(1);
                }

                sql = "SELECT SUM(total_price) FROM pembelian WHERE MONTH(date) = ?"; // Sesuaikan query dengan bulan
                PreparedStatement stmtPembelian = conn.prepareStatement(sql);
                stmtPembelian.setInt(1, i + 1);  // Set bulan
                ResultSet rsPembelian = stmtPembelian.executeQuery();
                if (rsPembelian.next()) {
                    pembelianData[i] = rsPembelian.getDouble(1);
                }

                keuntunganData[i] = penjualanData[i] - pembelianData[i];
            }

            // Menambahkan data ke chart
            for (int i = 0; i < months.length; i++) {
                chart.addData(new Chart_Model(months[i], new double[]{penjualanData[i], pembelianData[i], keuntunganData[i]}));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        chart.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        card3 = new komponen.Card();
        card2 = new komponen.Card();
        card1 = new komponen.Card();
        jPanel1 = new javax.swing.JPanel();
        btnRefresh = new swing.Button();
        chart = new swing.Chart();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(941, 634));

        jLayeredPane1.setMinimumSize(new java.awt.Dimension(326, 172));
        jLayeredPane1.setPreferredSize(new java.awt.Dimension(1167, 191));
        jLayeredPane1.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        card3.setColor1(new java.awt.Color(2, 0, 108));
        card3.setColor2(new java.awt.Color(153, 204, 255));
        jLayeredPane1.add(card3);

        card2.setColor1(new java.awt.Color(2, 0, 108));
        card2.setColor2(new java.awt.Color(153, 204, 255));
        jLayeredPane1.add(card2);

        card1.setColor1(new java.awt.Color(2, 0, 108));
        card1.setColor2(new java.awt.Color(153, 204, 255));
        jLayeredPane1.add(card1);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnRefresh.setBackground(new java.awt.Color(0, 204, 255));
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        chart.setBackground(new java.awt.Color(237, 246, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(412, 412, 412))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chart, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        updateChartData();
    }//GEN-LAST:event_btnRefreshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button btnRefresh;
    private komponen.Card card1;
    private komponen.Card card2;
    private komponen.Card card3;
    private swing.Chart chart;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
