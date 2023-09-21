public class Example2 {
    public static void main(String[] args) {
        // явное преобразование типа (целевой тип) выражения
        int a = 10;
//        char sim = a; // неявное преобразование
        char sim = (char) a;

        //overflow (переполнение)
        short value = 256;
//        byte bb = value; неявное преобразование
        byte bb = (byte) value; // результат 0

        //underflow (потеря значения)
        double x = 3.1415;
        a = (int) x; // результат 3

        //promotion rules
        // 1) char, byte и short повышаются до int
        // 2) расширение типа выражения до типа с наиболее широким диапозоном
        // согласно цепочке int -> long -> float -> double
        byte b = 10;
        int i = b * b;
        b = (byte) (b * b);

        char ch1 = 'a', ch2 = 'b';
        ch1 = (char) (ch1 + ch2);

    }
}
