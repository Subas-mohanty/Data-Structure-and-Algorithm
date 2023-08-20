package Lecture_practice_problems._23_Recursion_01;

public class _02_basic_recursion {
    public static void main(String[] args) {
        print(1);
    }
    static void print(int n){
        // if we don't put the check over here then it will run until the stack is full and that is called stackoverflow
        if (n == 5) {
            System.out.println(5);
            return;
        }
        System.out.println(n);

        // recursive call
        // if we are calling a function again and again , we can treat it as a separate call in the stack

        // this is tail recursion
        // this is the last function call
        print(n+1);
    }
}
