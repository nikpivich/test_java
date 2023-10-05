package Metod;

import java.util.Scanner;

// Пользователь вводит границы диапазона целых неотрицательных чисел
// Нужно вывести из этого диапазона число с максиальной суммой цифр
// Если таких чисел несколько, то выводится первое из них
public class Examle2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int result = maxSummDigits(a, b);
        System.out.println(result);
    }

    static int maxSummDigits(int a, int b){
        if (a > b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        int max = a;
        int maxSumm = sumDigits(a);
        a++;
        while (a <= b){
            int sum = sumDigits(a);
            if (sum > maxSumm){
                maxSumm =sum;
                max = a;
            }
            a++;
        }
        return max;
    }
    static int sumDigits(int a){
        int sum = 0;
        while (a!=0){
            sum += a % 10;
            a /= 10;
        }
    return sum;
    }

}
