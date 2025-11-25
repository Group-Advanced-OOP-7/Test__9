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
            // Create Account logic
            btnCreate.addActionListener(e -> {
                String fullName = txtFullName.getText();
                String email = txtEmail.getText();
                String phone = txtPhone.getText();
                String username = txtUsername.getText();
                String password = new String(txtPassword.getPassword());
                String confirm = new String(txtConfirm.getPassword());

                if (fullName.isEmpty() || email.isEmpty() || phone.isEmpty() ||
                        username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please fill all fields!");
                    return;
                }
                if (!password.equals(confirm)) {
                    JOptionPane.showMessageDialog(frame, "Passwords do not match!");
                    return;
                }

                if (registerUser(fullName, email, phone, username, password)) {
                    JOptionPane.showMessageDialog(frame, "Account created successfully!");
                    frame.dispose();
                    showLoginForm();
                } else {
                    JOptionPane.showMessageDialog(frame, "Username already exists or error
                            saving data.");
                }
            });

            btnBack.addActionListener(e -> {
                frame.dispose();
                showLoginForm();
            });
        }


        private void showDashboard(String username) {
            frame = new JFrame("Dashboard");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            frame.setLocationRelativeTo(null);

            JLabel lblWelcome = new JLabel("Welcome, " + username + "!", SwingConstants.CENTER);
            lblWelcome.setFont(new Font("Segoe UI", Font.BOLD, 18));
            JButton btnLogout = new JButton("Logout");
            btnLogout.addActionListener(e -> {
                frame.dispose();
                showLoginForm();
            });

            frame.setLayout(new BorderLayout());
            frame.add(lblWelcome, BorderLayout.CENTER);
            frame.add(btnLogout, BorderLayout.SOUTH);

            frame.setVisible(true);
        }

      
        private boolean registerUser(String fullName, String email, String phone,
                String username, String password) {
            String sql = "INSERT INTO users (fullname, email, phone, username, password) VALUES (?, ?, ?, ?, ?)";
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean loginUser(String username, String password) {
        String sql = "SELECT * FROM users WHERE username=? AND password=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            return rs.next(); // true if match found
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Application::new);}
}
        }
}