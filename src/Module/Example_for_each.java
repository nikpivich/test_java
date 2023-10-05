package Module;

public class Example_for_each {
    public static void main(String[] args) {
        double b[] = {3.5, 6.3, 8.4}; //объявлен массив b из трех элементов типа double
        for (double x : b) { //для элемента типа double (назовем его x) из массива b
            System.out.print(x + " "); //вывести этот элемент на консоль
        }
    }
}
