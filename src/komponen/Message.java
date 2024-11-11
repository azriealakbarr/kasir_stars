package komponen;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;

public class Message extends javax.swing.JPanel {
    
    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }
    private Messagetype messageType = Messagetype.SUCCESS;
    private boolean show;
    
    public Message() {
        initComponents();
        setOpaque(false);
        setVisible(false);
    }

    public void showMessage(Messagetype messageType, String message) {
        this.messageType = messageType;
        lblMesasge.setText(message);
        if (messageType == Messagetype.SUCCESS) {
            lblMesasge.setIcon(new ImageIcon(getClass().getResource("/icon/success.png")));
        } else {
            lblMesasge.setIcon(new ImageIcon(getClass().getResource("/icon/error.png")));
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblMesasge = new javax.swing.JLabel();

        lblMesasge.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblMesasge.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMesasge.setText("Message");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblMesasge, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblMesasge, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g3 = (Graphics2D) g;
        if (messageType == Messagetype.SUCCESS) {
            g3.setColor(new Color(15, 174, 37));
        } else {
            g3.setColor(new Color(240, 52, 53));
        }
        g3.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.9f));
        g3.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        g3.setComposite(AlphaComposite.SrcOver);
        g3.setColor(new Color(245, 245, 245));
        g3.drawRect(0, 0, getWidth() -1, getHeight() -1);
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public static enum Messagetype {
        SUCCESS, ERROR
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblMesasge;
    // End of variables declaration//GEN-END:variables
}
