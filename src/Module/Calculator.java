package Module;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int a = scan.nextInt();
        String znak = scan.next(); //знак вводим как строку
        int b = scan.nextInt();
        int result=0;
        boolean flag=true; //признак того, что выводить результат нужно
        switch(znak){
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                if (b == 0){
                    System.out.println("ERROR");
                    flag = false; //в конце программы вывод будет не нужен
                }else {
                    result = a / b;
                }
                break;
            case "%":
                if (b == 0) {
                    System.out.println("ERROR");
                    flag = false; //вывод не нужен
                }else {
                    result = a % b;
                }
                break;
            default:
                System.out.println("ERROR");
                flag = false; //и в этом случае вывод результата не нужен
        }
        if (flag) {  //если flag остался true, то вывод нужен
            System.out.println(result);
        }
    }
}

