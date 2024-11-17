package komponen;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import swing.button_outline_login;

public class PanelCover_Login extends javax.swing.JPanel {

    private final DecimalFormat df = new DecimalFormat("##0.###", DecimalFormatSymbols.getInstance(Locale.US));
    private ActionListener event;
    private MigLayout layout;
    private JLabel title;
    private JLabel desc;
    private JLabel desc1;
    private button_outline_login button;
    private boolean isLogin;
    private Object add;

    public PanelCover_Login() {
        initComponents();
        setOpaque(false);
        layout = new MigLayout("wrap, fill", "[center]", "push[]25[]10[]25[]push");
        setLayout(layout);
        init();
        

    }

    private void init() {
        title = new JLabel();
        title.setIcon(new ImageIcon(getClass().getResource("/icon/y (2).png")));
        add(title);
        desc = new JLabel("To keep connected with us please");
        desc.setForeground(new Color(245, 245, 245));
        add(desc);
        desc1 = new JLabel("login with your personal info");
        desc1.setForeground(new Color(245, 245, 245));
        add(desc1);
        button = new button_outline_login();
        button.setBackground(new Color(255, 255, 255));
        button.setForeground(new Color(255, 255, 255));
        button.setText("SIGN IN");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                event.actionPerformed(ae);
            }
        });
        add(button, "w 60%, h 40");
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g1 = (Graphics2D) grphcs;
        GradientPaint gra1 = new GradientPaint(0, 260, new Color(2, 23, 55), 0, getHeight(), new Color(45, 116, 150));
        g1.setPaint(gra1);
        g1.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(grphcs);
    }

    public void addEvent(ActionListener event) {
        this.event = event;
    }

    public void registerLeft(double v) {
        v = Double.valueOf(df.format(v));
        login(false);
        layout.setComponentConstraints(title, "pad 0 -" + v + "% 0 0");
        layout.setComponentConstraints(desc, "pad 0 -" + v + "% 0 0");
        layout.setComponentConstraints(desc1, "pad 0 -" + v + "% 0 0");
    }

    public void registerRight(double v) {
        v = Double.valueOf(df.format(v));
        login(false);
        layout.setComponentConstraints(title, "pad 0 -" + v + "% 0 0");
        layout.setComponentConstraints(desc, "pad 0 -" + v + "% 0 0");
        layout.setComponentConstraints(desc1, "pad 0 -" + v + "% 0 0");
    }

    public void loginLeft(double v) {
        v = Double.valueOf(df.format(v));
        login(true);
        layout.setComponentConstraints(title, "pad 0 " + v + "% 0 " + v + "%");
        layout.setComponentConstraints(desc, "pad 0 " + v + "% 0 " + v + "%");
        layout.setComponentConstraints(desc1, "pad 0 " + v + "% 0 " + v + "%");
    }

    public void loginRight(double v) {
        v = Double.valueOf(df.format(v));
        login(true);
        layout.setComponentConstraints(title, "pad 0 " + v + "% 0 " + v + "%");
        layout.setComponentConstraints(desc, "pad 0 " + v + "% 0 " + v + "%");
        layout.setComponentConstraints(desc1, "pad 0 " + v + "% 0 " + v + "%");
    }

    public void login(boolean login) {
        if (this.isLogin != login) {
            if (login) {
                title.setIcon(new ImageIcon(getClass().getResource("/icon/logo.png")));
                desc.setText("HI, WELCOME!");
                desc1.setText("Create Account First!");
                button.setText("REGISTER");
            } else {
                title.setIcon(new ImageIcon(getClass().getResource("/icon/logo.png")));
                desc.setText("HI! WELCOME BACK!");
                desc1.setText("Already Have Account?");
                button.setText("SIGN IN");
            }
            this.isLogin = login;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
