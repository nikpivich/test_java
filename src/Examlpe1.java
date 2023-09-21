public class Examlpe1 {
    public static void main(String[] args) {
        // byte -> short -> int ->long -> float -> double
        int a = 10;
        long b = a;
//        short k = a;

        // boolean не совместим счисловыми типами или char
//        boolean flag = 1;
//        int k = false;

        // переменной типа char нельзя присвоить значение числовой переменной, но можно литерал
//        char sim = a;
        char sim = 10;

        // числовой переменной (кроме short и byte) можно присвоить char
        a = sim;
//        short n = sim;
        // при неявном преобразовании может быть потеря точности
        int big = 123456789;
        float f = big;
        System.out.printf("%f", f);

    }
}
