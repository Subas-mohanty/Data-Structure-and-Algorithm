package Lecture_practice_problems._27_Recursion_02;

public class _06_Reverse {
    public static void main(String[] args) {
//        rev1(1234);
//        System.out.println(sum);
        System.out.println(rev2(-123));
    }
    static int sum=0;
    static void rev1(int n){
        if (n == 0) {
            return;
        }
        int rem=n%10;
        sum=sum*10+rem;
        rev1(n/10);
    }
    static int rev2(int n){
        //sometimes we need additional variables in the argument, in that case make another helper function
        int digits=(int) Math.log10(n)+1; // this gives the no of digits in a number
        return helper(n,digits);
    }

    private static int helper(int n, int digits) {
        // While only one digit is left we return that digit
        if(n%10==n){
            return n;
        }
        int rem=n%10;
        return (int)(rem*(Math.pow(10,digits-1))) + helper(n/10,digits-1);
    }
}
