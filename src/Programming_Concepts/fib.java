package Programming_Concepts;

import java.util.Arrays;
import java.util.Scanner;

public class fib {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num=scanner.nextInt();
        double [] arr=new double[num];
        double [] ans=f(num,arr);
//        System.out.println(Arrays.toString(ans));
        divisors(ans);
    }

    private static void divisors(double[] ans) {
        for (int i = 2; i < ans.length ; i++) {
            System.out.println(ans[i] + "/" + ans[i-1] + " = " + ans[i]/ans[i-1]);
        }
    }

    public static double[] f(double n, double [] arr){
        if (n < 1) {
            return new double[]{n};
        }
        arr[0]=0;
        arr[1]=1;
        for (int i = 2; i <n; i++) {
           arr[i]=arr[i-1]+arr[i-2];
        }
        return arr;
    }
}
