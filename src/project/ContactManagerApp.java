package project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ContactManagerApp {

    private ArrayList<Contact> contacts;
    private JFrame frame;
    private JTextField nameField, emailField;
    private DefaultListModel<Contact> listModel;
    private JList<Contact> contactList;

    public ContactManagerApp() {
        contacts = new ArrayList<>();

        frame = new JFrame("Contact Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField();

        JButton addButton = new JButton("Add Contact");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addContact();
            }
        });

        listModel = new DefaultListModel<>();
        contactList = new JList<>(listModel);

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(addButton);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(contactList), BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private void addContact() {
        String name = nameField.getText();
        String email = emailField.getText();

        if (!name.isEmpty() && !email.isEmpty()) {
            Contact contact = new Contact(name, email);
            contacts.add(contact);
            listModel.addElement(contact);

            // Очистка полей ввода после добавления контакта
            nameField.setText("");
            emailField.setText("");
        } else {
            JOptionPane.showMessageDialog(frame, "Please enter both name and email.");
        }
    }

    private class Contact {
        private String name;
        private String email;

        public Contact(String name, String email) {
            this.name = name;
            this.email = email;
        }

        @Override
        public String toString() {
            return name + " - " + email;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ContactManagerApp();
            }
        });
    }
}
