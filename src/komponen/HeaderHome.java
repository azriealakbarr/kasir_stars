package komponen;

import javax.swing.*;
import java.awt.*;

public class HeaderHome extends JPanel {
    private JTextField txtMenuName;

    public HeaderHome() {
        initComponents();
    }

    private void initComponents() {
        // Atur warna latar belakang menjadi putih
        this.setBackground(Color.WHITE);

        // Atur ukuran panel
        this.setPreferredSize(new Dimension(688, 45));
        this.setMinimumSize(new Dimension(688, 45));
        this.setMaximumSize(new Dimension(688, 45));

        // Tambahkan JTextField untuk menampilkan nama menu
        txtMenuName = new JTextField();
        txtMenuName.setEditable(false);
        txtMenuName.setFont(new Font("Arial", Font.BOLD, 16));
        txtMenuName.setHorizontalAlignment(JTextField.LEFT);
        txtMenuName.setText("  Dashboard");
        txtMenuName.setBorder(null); // Hilangkan border
        txtMenuName.setOpaque(false); // Latar belakang transparan
        txtMenuName.setPreferredSize(new Dimension(688, 45));
        txtMenuName.setMinimumSize(new Dimension(688, 45));
        txtMenuName.setMaximumSize(new Dimension(688, 45));

        // Pastikan TextField mengisi seluruh panel
        this.setLayout(new BorderLayout());
        this.add(txtMenuName, BorderLayout.CENTER);
    }

    public void setMenuName(String name) {
        txtMenuName.setText(name);
    }
}
