import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegistrationForm extends JFrame {
    private JTextField nameField, emailField;
    private JPasswordField passwordField, confirmPasswordField;
    private JButton submitButton, clearButton;

    public RegistrationForm() {
        // Set up the frame
        setTitle("User Registration");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Create main panel with GridBagLayout
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Create components
        JLabel nameLabel = new JLabel("Name:");
        JLabel emailLabel = new JLabel("Email:");
        JLabel passwordLabel = new JLabel("Password:");
        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");

        nameField = new JTextField(20);
        emailField = new JTextField(20);
        passwordField = new JPasswordField(20);
        confirmPasswordField = new JPasswordField(20);

        submitButton = new JButton("Submit");
        clearButton = new JButton("Clear");

        // Add components to panel
        // Name row
        gbc.gridx = 0; gbc.gridy = 0;
        mainPanel.add(nameLabel, gbc);
        gbc.gridx = 1;
        mainPanel.add(nameField, gbc);

        // Email row
        gbc.gridx = 0; gbc.gridy = 1;
        mainPanel.add(emailLabel, gbc);
        gbc.gridx = 1;
        mainPanel.add(emailField, gbc);

        // Password row
        gbc.gridx = 0; gbc.gridy = 2;
        mainPanel.add(passwordLabel, gbc);
        gbc.gridx = 1;
        mainPanel.add(passwordField, gbc);

        // Confirm Password row
        gbc.gridx = 0; gbc.gridy = 3;
        mainPanel.add(confirmPasswordLabel, gbc);
        gbc.gridx = 1;
        mainPanel.add(confirmPasswordField, gbc);

        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(submitButton);
        buttonPanel.add(clearButton);

        gbc.gridx = 0; gbc.gridy = 4;
        gbc.gridwidth = 2;
        mainPanel.add(buttonPanel, gbc);

        // Add main panel to frame
        add(mainPanel);

        // Add action listeners
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validateFields()) {
                    displayInformation();
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });
    }

    private boolean validateFields() {
        if (nameField.getText().trim().isEmpty() ||
            emailField.getText().trim().isEmpty() ||
            new String(passwordField.getPassword()).trim().isEmpty() ||
            new String(confirmPasswordField.getPassword()).trim().isEmpty()) {
            
            JOptionPane.showMessageDialog(this,
                "All fields must be filled out!",
                "Validation Error",
                JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Check if passwords match
        String password = new String(passwordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());
        
        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this,
                "Passwords do not match!",
                "Validation Error",
                JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    private void displayInformation() {
        String message = "Registration Information:\n\n" +
                        "Name: " + nameField.getText() + "\n" +
                        "Email: " + emailField.getText() + "\n" +
                        "Password: " + "*".repeat(passwordField.getPassword().length);

        JOptionPane.showMessageDialog(this,
            message,
            "Registration Successful",
            JOptionPane.INFORMATION_MESSAGE);
    }

    private void clearFields() {
        nameField.setText("");
        emailField.setText("");
        passwordField.setText("");
        confirmPasswordField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new RegistrationForm().setVisible(true);
            }
        });
    }
}