package Lecture_practice_problems_kunal_kushwaha._23_Recursion_01;

public class _03_fibonacci_series {
    public static void main(String[] args) {
        for (int i = 0; i < 11; i++) {
            System.out.println(fibFormula(i));
        }
        int ans=fibFormula(50);
        System.out.println(ans);
    }
    static int fibFormula(int n){
        // we can convert this to long as well cause the range of int may be exceeded
        return (int)((Math.pow(( 1+Math.sqrt(5))/2 ,n)- (Math.pow((1-Math.sqrt(5))/2,n)))/Math.sqrt(5));
    }
    static int fib(int n){
        // Base condition
        if (n < 2) {
            return n;
        }
        return fib(n-1)+fib(n-2);
    }
}
