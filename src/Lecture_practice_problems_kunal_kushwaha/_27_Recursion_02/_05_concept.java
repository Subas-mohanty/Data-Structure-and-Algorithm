package Lecture_practice_problems_kunal_kushwaha._27_Recursion_02;

public class _05_concept {
    public static void main(String[] args) {
        fun(5);
    }
    static void fun(int n){
        if (n == 0) {
            return;
        }
        System.out.println(n);
//        fun(n--); // go to a infinite loop as the n-- thing will pass the value first then decrement the value , hence it will always pass 5 , and it will go to an infinite loop
        fun(--n); // it will do the required work as it is decrementing the value first and then passing it to the function
    }
}
