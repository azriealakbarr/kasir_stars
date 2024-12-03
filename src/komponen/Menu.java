package komponen;

import event.EventMenuSelected;
import model.Model_Menu;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;

public class Menu extends javax.swing.JPanel {

    private EventMenuSelected event;

    public void addEventMenuSelected(EventMenuSelected event) {
        this.event = event;
        listMenu.addEventMenuSelected(event);
    }

    public Menu() {
        initComponents();
        setOpaque(false);
        listMenu.setOpaque(false);
        init();
    }

    private void init() {
        listMenu.addItem(new Model_Menu("Dashboard", Model_Menu.MenuType.MENU));
        listMenu.addItem(new Model_Menu("Produk", Model_Menu.MenuType.MENU));
        listMenu.addItem(new Model_Menu("Penjualan", Model_Menu.MenuType.MENU));
        listMenu.addItem(new Model_Menu("Pembelian", Model_Menu.MenuType.MENU));
        listMenu.addItem(new Model_Menu("Laporan", Model_Menu.MenuType.MENU));

        listMenu.addItem(new Model_Menu(" ", Model_Menu.MenuType.EMPTY));
        listMenu.addItem(new Model_Menu(" ", Model_Menu.MenuType.EMPTY));

        listMenu.addItem(new Model_Menu("Logout", Model_Menu.MenuType.MENU));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMoving = new javax.swing.JPanel();
        lbLogo = new javax.swing.JLabel();
        listMenu = new swing.MenuList<>();

        panelMoving.setOpaque(false);
        panelMoving.setPreferredSize(new java.awt.Dimension(215, 91));

        lbLogo.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbLogo.setForeground(new java.awt.Color(255, 255, 255));
        lbLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logoMenu.png"))); // NOI18N

        javax.swing.GroupLayout panelMovingLayout = new javax.swing.GroupLayout(panelMoving);
        panelMoving.setLayout(panelMovingLayout);
        panelMovingLayout.setHorizontalGroup(
            panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 215, Short.MAX_VALUE)
            .addGroup(panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMovingLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lbLogo, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        panelMovingLayout.setVerticalGroup(
            panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 91, Short.MAX_VALUE)
            .addGroup(panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMovingLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lbLogo, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMoving, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(listMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelMoving, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 106, Short.MAX_VALUE)
                    .addComponent(listMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintChildren(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint g = new GradientPaint(0, 0, Color.decode("#1CB5E0"), 0, getHeight(), Color.decode("#000046"));
        g2.setPaint(g);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.fillRect(getWidth() - 20, 0, getWidth(), getHeight());
        super.paintChildren(grphcs);
    }

    private int x, y;

    public void initMoving(JFrame fram) {
        panelMoving.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                x = me.getX();
                y = me.getY();
            }

        });
        panelMoving.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent me) {
                fram.setLocation(me.getXOnScreen() - x, me.getYOnScreen() - y);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbLogo;
    private swing.MenuList<String> listMenu;
    private javax.swing.JPanel panelMoving;
    // End of variables declaration//GEN-END:variables
}
