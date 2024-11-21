package form;

import model.Model_Card;
import model.StatusType;
import swing.ScrollBar;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Form_Dashboard extends javax.swing.JPanel {

    public Form_Dashboard() {
        initComponents();
        card1.setData(new Model_Card(new ImageIcon(getClass().getResource("/icon/stock.png")), "Total Penjualan", "$200000", "Increased by 60%"));
        card2.setData(new Model_Card(new ImageIcon(getClass().getResource("/icon/profit.png")), "Total Pembelian", "$15000", "Increased by 25%"));
        card3.setData(new Model_Card(new ImageIcon(getClass().getResource("/icon/flag.png")), "Total Profit", "$300000", "Increased by 70%"));
      }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        card3 = new komponen.Card();
        card2 = new komponen.Card();
        card1 = new komponen.Card();
        panelBorder1 = new swing.PanelBorder();

        setPreferredSize(new java.awt.Dimension(941, 634));

        jLayeredPane1.setMinimumSize(new java.awt.Dimension(326, 172));
        jLayeredPane1.setPreferredSize(new java.awt.Dimension(1167, 191));
        jLayeredPane1.setLayout(new java.awt.GridLayout(1, 0, 10, 0));
        jLayeredPane1.add(card3);
        jLayeredPane1.add(card2);
        jLayeredPane1.add(card1);

        panelBorder1.setPreferredSize(new java.awt.Dimension(887, 371));

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 901, Short.MAX_VALUE)
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, 901, Short.MAX_VALUE)
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 901, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private komponen.Card card1;
    private komponen.Card card2;
    private komponen.Card card3;
    private javax.swing.JLayeredPane jLayeredPane1;
    private swing.PanelBorder panelBorder1;
    // End of variables declaration//GEN-END:variables
}
