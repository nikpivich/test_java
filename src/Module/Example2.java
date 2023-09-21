package Module;

import java.util.Scanner;

public class Example2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        if (number < 0) number = -number;
        if (number < 100 || number > 999) { //неверные исходные данные
            System.out.println("ERROR");
            return; //прекращение работы программы
        }
        //поиск суммы нечетных цифр
    }
}
