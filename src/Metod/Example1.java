package Metod;

public class Example1 {
    public static void main(String[] args) {
        double a = 3.4;
        double b = 6.7;
        double c = -2.7;
        double result = maximum(a,b,c);
        System.out.println(result);
    }
    static double maximum(double x, double y, double z){
        double max = x > y? x:y; // Усли х больше у, то результат х иначе у
        max =  z > max? z : max;
        return max;
    }
}
