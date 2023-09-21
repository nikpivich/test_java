import java.util.Scanner;

public class Example4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите ваше имя: ");
        String name;
        name = scan.nextLine();
        System.out.println("Привет" + name + "!");
        System.out.println("Сколько вам лет?");
        if (scan.hasNextInt()) { // Проверка на число
            int age;
            age = scan.nextInt();
            System.out.println(age + " - это много!");
        }else {
            System.out.println("Неверный формат данных");
        }
    }
}
