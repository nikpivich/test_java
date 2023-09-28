package Tasks;

import java.util.Scanner;

/**
 * Пользователь вводит 10 оценок ученика (в 10-балльной системе).
 * Нужно подсчитать, сколько среди них неудовлетворительных оценок (менее 4 баллов)
 */
public class Average_rating {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int number;
//        number = scan.nextInt();
        final int count = 10;
        int kol = 0;
        int kol1 = 0;
        while(kol < count){
            number = scan.nextInt();
            if (number<=4){
                kol1++;
            }
            kol++;
        }
        System.out.println(kol1);
    }
}
