package komponen;

import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import swing.TextField_pass;
import swing.TextField;
import model.ModelLogin_Register;
import model.ModelLogin_Login;

public class PanelLoginRegister extends javax.swing.JLayeredPane {
    
    public ModelLogin_Register getUser_id() {
        return user_id;
    }
    
    public ModelLogin_Login getDataLogin() {
        return dataLogin;
    }
    
    private ModelLogin_Register user_id;
    private ModelLogin_Login dataLogin;
    
    public PanelLoginRegister(ActionListener eventRegister, ActionListener eventLogin) {
        initComponents();
        initRegister(eventRegister);
        initLogin(eventLogin);
        login.setVisible(false);
        register.setVisible(true);
    }


    private void initRegister(ActionListener eventRegister) {
        register.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        JLabel label = new JLabel("Create Account");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(2, 23, 55));
        register.add(label);
        TextField txtUser = new TextField();
        txtUser.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/user.png")));
        txtUser.setHint("Username");
        register.add(txtUser, "w 60%");
        TextField txtEmail = new TextField();
        txtEmail.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/mail.png")));
        txtEmail.setHint("Email");
        register.add(txtEmail, "w 60%");
        TextField_pass txtPass = new TextField_pass();
        txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/pass.png")));
        txtPass.setHint("Password");
        register.add(txtPass, "w 60%");
        JButton cmd = new JButton();
        cmd.setBackground(new Color(2, 23, 55));
        cmd.setForeground(new Color(250, 250, 250));;
        cmd.addActionListener(eventRegister);
        cmd.setText("Sign Up");
        register.add(cmd, "w 40%, h 40");
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String username = txtUser.getText().trim();
                String email = txtEmail.getText().trim();
                String password = String.valueOf(txtPass.getPassword());
                user_id = new ModelLogin_Register(0, username, email, password);
            }
        });
    }

    private void initLogin(ActionListener eventLogin) {
        login.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        JLabel label = new JLabel("Log In");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(2, 23, 55));
        login.add(label);
        TextField txtUser = new TextField();
        txtUser.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/user.png")));
        txtUser.setHint("Username");
        login.add(txtUser, "w 60%");
        TextField_pass txtPass = new TextField_pass();
        txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/pass.png")));
        txtPass.setHint("Password");
        login.add(txtPass, "w 60%");
        JButton cmd = new JButton();
        cmd.setBackground(new Color(2, 23, 55));
        cmd.setForeground(new Color(255, 255, 255));
        cmd.addActionListener(eventLogin);
        cmd.setText("LOGIN");
        login.add(cmd, "w 40%, h 40");
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String username = txtUser.getText().trim();
                String password = String.valueOf(txtPass.getPassword());
                dataLogin = new ModelLogin_Login (username, password);
            }    
        });
    }

    public void showRegister(boolean show) {
        if (show) {
            register.setVisible(true);
            login.setVisible(false);
        } else {
            register.setVisible(false);
            login.setVisible(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        login = new javax.swing.JPanel();
        register = new javax.swing.JPanel();

        setLayout(new java.awt.CardLayout());

        login.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(login, "card3");

        register.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout registerLayout = new javax.swing.GroupLayout(register);
        register.setLayout(registerLayout);
        registerLayout.setHorizontalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );
        registerLayout.setVerticalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(register, "card2");
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel login;
    private javax.swing.JPanel register;
    // End of variables declaration//GEN-END:variables
}
