package Lecture_practice_problems._11_functions_methods;

import java.util.Scanner;

// In java functions are called methods because when functions are used inside classes they are called methods and in java all th functions are declared inside a class as java is a class-based, object-oriented programming language
public class Sum {
    public static void main(String[] args) {
//        int ans = sum2();
//        System.out.println(ans);

        int ans = sum3(20, 30);
        System.out.println(ans);
    }

    // pass the value of numbers when you are calling the method in main()
    static int sum3(int a, int b) {
        int sum = a + b;
        return sum;
    }

    // return the value
    static int sum2() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number 1: ");
        int num1 = in.nextInt();
        System.out.print("Enter number 2: ");
        int num2 = in.nextInt();
        int sum = num1 + num2;
        return sum;
//        System.out.println("This will never execute");
    }

    static void sum() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number 1: ");
        int num1 = in.nextInt();
        System.out.print("Enter number 2: ");
        int num2 = in.nextInt();
        int sum = num1 + num2;
        System.out.println("The sum = " + sum);
    }

    /*
        return_type name (arguments) {
            // body
            return statement;
        }

     */
}