package main;

import db.db_connection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import javax.swing.JLayeredPane;
import javax.swing.Timer;
import komponen.Message;
import komponen.PanelCover_Login;
import komponen.PanelLoading;
import komponen.PanelLoginRegister;
import main.Main_Home;
import model.ModelLogin_User;
import model.ModelLogin_Login;
import model.ModelLogin_Message;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import service.ServiceLogin_Mail;
import service.ServiceLogin_User;

public class Main_Login extends javax.swing.JFrame {

    private final DecimalFormat df = new DecimalFormat("##0.###", DecimalFormatSymbols.getInstance(Locale.US));
    private MigLayout layout;
    private PanelCover_Login cover;
    private PanelLoading loading;
    private PanelLoginRegister loginRegister;
    private boolean isLogin;
    private final double addSize = 30;
    private final double coverSize = 40;
    private final double loginSize = 60;
    private ServiceLogin_User service;

    public Main_Login() {
        initComponents();
        init();
    }

    private void init() {
        service = new ServiceLogin_User();
        layout = new MigLayout("fill, insets 0");
        cover = new PanelCover_Login();
        ActionListener eventRegister = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                register();
            }
            
        };
        ActionListener eventLogin = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
            
        };
        loginRegister = new PanelLoginRegister(eventRegister, eventLogin);
        loading = new PanelLoading();
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                double fractionCover;
                double fractionLogin;
                double size = coverSize;
                if (fraction <= 0.5f) {
                    size += fraction * addSize;
                } else {
                    size += addSize - fraction * addSize;
                }
                if (isLogin) {
                    fractionCover = 1f - fraction;
                    fractionLogin = fraction;
                    if (fraction >= 0.5f) {
                        cover.registerRight(fractionCover * 100);
                    } else {
                        cover.loginRight(fractionLogin * 100);
                    }
                } else {
                    fractionCover = fraction;
                    fractionLogin = 1f - fraction;
                    if (fraction <= 0.5f) {
                        cover.registerLeft(fraction * 100);
                    } else {
                        cover.loginLeft((1f - fraction) * 100);
                    }
                }
                if (fraction >= 0.5f) {
                    loginRegister.showRegister(isLogin);
                }
                fractionCover = Double.valueOf(df.format(fractionCover));
                fractionLogin = Double.valueOf(df.format(fractionLogin));
                layout.setComponentConstraints(cover, "width " + size + "%, pos " + fractionCover + "al 0 n 100%");
                layout.setComponentConstraints(loginRegister, "width " + loginSize + "%, pos " + fractionLogin + "al 0 n 100%");
                bg.revalidate();
            }

            @Override
            public void end() {
                isLogin = !isLogin;
            }
        };
        Animator animator = new Animator(800, target);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        animator.setResolution(0);  //  for smooth animation
        bg.setLayout(layout);
        bg.setLayer(loading, JLayeredPane.POPUP_LAYER);
        bg.add(loading, "pos 0 0 100% 100%");
        bg.add(cover, "width " + coverSize + "%, pos " + (isLogin ? "1al" : "0al") + " 0 n 100%");
        bg.add(loginRegister, "width " + loginSize + "%, pos " + (isLogin ? "0al" : "1al") + " 0 n 100%"); //  1al as 100%
        cover.addEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!animator.isRunning()) {
                    animator.start();
                }
            }
        });
        
    }
    private void register(){
        ModelLogin_User user_id = loginRegister.getUser_id();
        loading.setVisible(true);
        try {
            if (service.checkDuplicateUser(user_id.getUsername())) {
                showMessage(Message.Messagetype.ERROR, "Username sudah digunakan");
            } else if (service.checkDuplicateEmail(user_id.getEmail())) {
                showMessage(Message.Messagetype.ERROR, "Email sudah digunakan");
            } else {
                service.insertUser(user_id);
                showMessage(Message.Messagetype.SUCCESS, "Register Sukses");
                
                new javax.swing.Timer(1500, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    loading.setVisible(false); // Menyembunyikan loading
                }
                }).start();
            }
        } catch (SQLException e) {
            showMessage(Message.Messagetype.ERROR, "Gagal Register");
        }

    }
    
    private void login() {
    ModelLogin_Login data = loginRegister.getDataLogin();
    try {
        if (data.getUsername().isEmpty() || data.getPassword().isEmpty()) { // Input Data
            showMessage(Message.Messagetype.ERROR, "Masukkan Username dan Password Anda");
            return;
        } 
        ModelLogin_User user_id = service.login_User(data);
        if (user_id != null) {
            this.dispose(); // Tutup jendela Main_Login
            Main_Home main = new Main_Home(); // Membuat instance dari Main
            main.setVisible(true); // Membuka jendela Main
        } else {
            showMessage(Message.Messagetype.ERROR, "Username atau Password Salah");
        }
    } catch (SQLException e) {
        System.err.println("Error during login cause: " + e.getMessage()); // Log for debugging
        showMessage(Message.Messagetype.ERROR, "Error saat masuk, coba lagi");
    }
}


    
    private void showMessage(Message.Messagetype messageType,String message) {
        Message msg = new Message();
        msg.showMessage(messageType, message);
        TimingTarget target = new TimingTargetAdapter(){
            @Override
            public void begin() {
                if (!msg.isShow()) {
                    bg.add(msg, "pos 0.5al -30", 0);
                    msg.setVisible(true);
                    bg.repaint();
                }
            }

            @Override
            public void timingEvent(float fraction) {
                float f;
                if(msg.isShow()) {
                  f = 40 * (1f-fraction)  ;
                }else {
                    f = 40*fraction;
                }
                layout.setComponentConstraints(msg, "pos 0.5al " +(int)( f - 30));
                bg.repaint();
                bg.revalidate();
            }

            @Override
            public void end() {
                if (msg.isShowing()) {
                    bg.remove(msg);
                    bg.repaint();
                    bg.revalidate();
                }else {
                    msg.setShow(true);
                }
            }
        
        };
        Animator animator = new Animator(300, target);
        animator.setResolution(0);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        animator.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(2000);
                    animator.start();;
                }catch(InterruptedException e){
                    System.err.println(e);
                }
            }
        }).start();
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bg.setOpaque(true);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 933, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 537, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        try {
            db_connection.getInstance().connectDatabase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables
}
