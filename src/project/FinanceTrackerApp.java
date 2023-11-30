package project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FinanceTrackerApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Финансовый трекер");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(4, 2));

        JLabel nameLabel = new JLabel("Название транзакции:");
        JTextField nameField = new JTextField();
        JLabel amountLabel = new JLabel("Сумма:");
        JTextField amountField = new JTextField();
        JButton addTransactionButton = new JButton("Добавить транзакцию");

        JTextArea transactionHistory = new JTextArea();
        transactionHistory.setEditable(false);

        addTransactionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                double amount = Double.parseDouble(amountField.getText());

                // Обработка транзакции (можно добавить логику сохранения в базу данных или файл)
                String transactionInfo = "Транзакция: " + name + ", Сумма: " + amount;
                transactionHistory.append(transactionInfo + "\n");

                // Очищаем поля после добавления транзакции
                nameField.setText("");
                amountField.setText("");
            }
        });

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(amountLabel);
        panel.add(amountField);
        panel.add(addTransactionButton);

        JScrollPane scrollPane = new JScrollPane(transactionHistory);
        panel.add(scrollPane);

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}

