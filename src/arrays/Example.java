package arrays;

import java.util.Scanner;

public class Example {
    public static void main(String[] args) {
        int[] a = new int[5];
        int[] b = new int[]{1,2,3,4,5};
        double[] c = {3.4, 5.6, 6.7};
//        System.out.println(b[1]);
        Scanner scan = new Scanner(System.in);
        int n;
        n = scan.nextInt();
        int[] q = new int[n];
        for(int i = 0; i < q.length; i++){
            q[i] = scan.nextInt();
        }
        for (int el:q){
            System.out.print(el + "");
        }
        System.out.println();
    }
}
