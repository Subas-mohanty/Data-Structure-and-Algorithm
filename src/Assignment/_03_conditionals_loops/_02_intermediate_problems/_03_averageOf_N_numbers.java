package Assignment._03_conditionals_loops._02_intermediate_problems;

import java.util.Scanner;

public class _03_averageOf_N_numbers {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a number :");
        int n=sc.nextInt();

        int sum=((n*n)+n)/2;
        System.out.println("The sum is "+sum);
    }
}
