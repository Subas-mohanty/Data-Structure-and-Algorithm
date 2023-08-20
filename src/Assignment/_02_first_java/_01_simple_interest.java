package Assignment._02_first_java;

import java.util.Scanner;

public class _01_simple_interest {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the principal amount :");
        int p=sc.nextInt();
        System.out.println("Enter the rate of interest :");
        int t=sc.nextInt();
        System.out.println("Enter the time in years :");
        int r=sc.nextInt();


        int interest=(p*t*r)/100;
        System.out.println("Your interest is "+ interest);
        System.out.println("And total amount is"+(p+interest));
    }
}
