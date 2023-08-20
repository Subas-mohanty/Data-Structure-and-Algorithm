package Lecture_practice_problems._25_math_for_DSA_01;

public class _01_evenOdd {
    public static void main(String[] args) {
        int n=39;
        System.out.println(isOdd(n));
        int ans=11&10;
        // This is working internally like this
//        11=1011
//        10=1010
//      -----------
//           1010   // this is doing and operation on each digit one by one and returning the resultant as whole, and its of integer type
        System.out.println(ans);
        int k=ans+2;
        System.out.println(k);
    }
    private static boolean isOdd(int n) {
        return (n&1)==1;
    }

}
