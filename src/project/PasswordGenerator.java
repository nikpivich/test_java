package project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SecureRandom;
public class PasswordGenerator {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Генератор паролей");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(3, 2));

        JLabel lengthLabel = new JLabel("Длина пароля:");
        JTextField lengthField = new JTextField();
        JLabel passwordLabel = new JLabel("Ваш пароль:");
        JTextField passwordField = new JTextField();
        JButton generateButton = new JButton("Сгенерировать пароль");

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int length = Integer.parseInt(lengthField.getText());
                String password = generatePassword(length);
                passwordField.setText(password);
            }
        });

        panel.add(lengthLabel);
        panel.add(lengthField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(generateButton);

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setSize(300, 150);
        frame.setVisible(true);
    }

    private static String generatePassword(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+";
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            password.append(characters.charAt(index));
        }

        return password.toString();
    }
}


