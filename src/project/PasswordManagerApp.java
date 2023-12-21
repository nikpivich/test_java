package project;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PasswordManagerApp {

    private static List<PasswordEntry> savedPasswords = new ArrayList<>();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Password Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel);

        placeComponents(panel);

        frame.setSize(400, 200);
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel siteLabel = new JLabel("Site:");
        siteLabel.setBounds(10, 20, 80, 25);
        panel.add(siteLabel);

        JTextField siteText = new JTextField(20);
        siteText.setBounds(100, 20, 165, 25);
        panel.add(siteText);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(10, 50, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(100, 50, 165, 25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 80, 80, 25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 80, 165, 25);
        panel.add(passwordText);

        JButton saveButton = new JButton("Save Password");
        saveButton.setBounds(10, 110, 150, 25);
        panel.add(saveButton);

        JButton showPasswordsButton = new JButton("Show Saved Passwords");
        showPasswordsButton.setBounds(180, 110, 200, 25);
        panel.add(showPasswordsButton);

        JTextArea savedPasswordsTextArea = new JTextArea();
        savedPasswordsTextArea.setEditable(false);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String site = siteText.getText();
                String username = userText.getText();
                char[] passwordChars = passwordText.getPassword();
                String password = new String(passwordChars);

                savePassword(site, username, password);

                siteText.setText("");
                userText.setText("");
                passwordText.setText("");

                JOptionPane.showMessageDialog(panel, "Password saved for site: " + site);
            }
        });

        showPasswordsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                savedPasswordsTextArea.setText(getSavedPasswords());
                JOptionPane.showMessageDialog(panel, new JScrollPane(savedPasswordsTextArea),
                        "Saved Passwords", JOptionPane.PLAIN_MESSAGE);
            }
        });
    }

    private static void savePassword(String site, String username, String password) {
        PasswordEntry entry = new PasswordEntry(site, username, password);
        savedPasswords.add(entry);
    }

    private static String getSavedPasswords() {
        StringBuilder passwords = new StringBuilder();
        for (PasswordEntry entry : savedPasswords) {
            passwords.append("Site: ").append(entry.getSite()).append("\n");
            passwords.append("Username: ").append(entry.getUsername()).append("\n");
            passwords.append("Password: ").append(entry.getPassword()).append("\n\n");
        }
        return passwords.toString();
    }

    private static class PasswordEntry {
        private String site;
        private String username;
        private String password;

        public PasswordEntry(String site, String username, String password) {
            this.site = site;
            this.username = username;
            this.password = password;
        }

        public String getSite() {
            return site;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }
}
