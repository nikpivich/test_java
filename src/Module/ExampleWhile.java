package Module;

import java.util.Scanner;

public class ExampleWhile {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        final int N=5;
        int mark, kol=0;//kol - счетчик введенных оценок
        double average=0; //среднее
        while(kol<N){
            mark=scan.nextInt(); //вводим оценку
            average+=mark; //прибавляем к  сумме
            kol++; //увеличиваем счетчик
        }
        average/=N;//вычисляем среднее
        System.out.printf("%.1f",average); //вывод с одним знаком после точки
    }
}
