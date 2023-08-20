package Lecture_practice_problems._27_Recursion_02;

public class _01_Nto1 {
    public static void main(String[] args) {
//        fun(5);
        funRev(5);
    }
    static void fun(int n){
        if (n == 0) {
            return;
        }
        System.out.println(n); // printing the values before making the recursive call
        fun(n-1);
    }
    static void funRev(int n){
        if (n == 0) {
            return;
        }
        funRev(n-1);
        System.out.println(n); // printing all the values after making all the recursive calls , and after it finishes all the calls it will return the values one by one from the last returns , so it will print from 1 to N
    }
}
