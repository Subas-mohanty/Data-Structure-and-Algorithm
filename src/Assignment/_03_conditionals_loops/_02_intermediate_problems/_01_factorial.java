package Assignment._03_conditionals_loops._02_intermediate_problems;

import java.util.Scanner;

public class _01_factorial {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number you want factorial of :");
        int num=sc.nextInt();
        int fact=1;
        int i=1;

        if (num == 0) {
            System.out.println("The factorial is "+1);
        }
        while(num>=i){
            fact*=i;
            i++;
        }
        System.out.println("The factorial is "+fact);
    }
}
