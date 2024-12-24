package Lecture_practice_problems_kunal_kushwaha._27_Recursion_02;

public class _02_factorial {
    public static void main(String[] args) {
        System.out.println(fact(6));
        System.out.println(sum(5));
    }
    static int fact(int n){
        if (n <= 1) {
            return 1;
        }
        return n*fact(n-1);
    }

    static int sum(int n){
        if (n <= 1) {
            return 1;
        }
        return n+sum(n-1);
    }
}
