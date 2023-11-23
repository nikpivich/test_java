import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SimpleSwingApp {
    public static void main(String[] args) {
        // Создаем фрейм (окно)
        JFrame frame = new JFrame("Пример приложения на Swing");

        // Создаем кнопку
        JButton button = new JButton("Нажми меня");

        // Добавляем слушателя событий для кнопки
        button.addActionListener(e -> {
            // Выводим сообщение при нажатии на кнопку
            JOptionPane.showMessageDialog(frame, "Привет, мир!");
        });

        // Добавляем кнопку в фрейм
        frame.getContentPane().add(button);

        // Устанавливаем параметры фрейма
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}