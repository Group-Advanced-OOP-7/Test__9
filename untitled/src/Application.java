import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Application {
    private JFrame frame;
    private JPanel mainPanel;

    public Application() {
        private JFrame frame;
        private JPanel mainPanel;

    public Application() {
            showLoginForm();
        }

        private void showLoginForm() {
            frame = new JFrame("Login");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            frame.setLocationRelativeTo(null);
            mainPanel = new JPanel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(8, 8, 8, 8);

            JLabel lblTitle = new JLabel("User Login");
            lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 20));
            gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
            mainPanel.add(lblTitle, gbc);

            gbc.gridwidth = 1;
            gbc.gridy++;
            mainPanel.add(new JLabel("Username:"), gbc);
            gbc.gridx = 1;
            JTextField txtUsername = new JTextField(15);
            mainPanel.add(txtUsername, gbc);

            gbc.gridx = 0; gbc.gridy++;
            mainPanel.add(new JLabel("Password:"), gbc);
            gbc.gridx = 1;
            JPasswordField txtPassword = new JPasswordField(15);
            mainPanel.add(txtPassword, gbc);

            gbc.gridy++;
            gbc.gridx = 0; gbc.gridwidth = 2;

            JButton btnLogin = new JButton("Login");
            JButton btnRegister = new JButton("Create Account");

            JPanel btnPanel = new JPanel();
            btnPanel.add(btnLogin);
            btnPanel.add(btnRegister);
            mainPanel.add(btnPanel, gbc);

            frame.add(mainPanel);
            frame.setVisible(true);


        }
}