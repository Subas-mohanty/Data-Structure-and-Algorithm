package Lecture_practice_problems._25_math_for_DSA_01;

public class _11_RangeXOR {
    public static void main(String[] args) {
        // range xor for a,b=xor(b)^xor(a-1)
        int a=3;
        int b=9;

        int ans=xor(b)^xor(a-1);
        System.out.println(ans);


        // this is only for check , this will give time limit exceed for large numbers
        int ans2=0;
        for (int i = a; i <= b; i++) {
            ans2^=i;
        }
        System.out.println(ans2);
    }
    // this gives xor from 0 to a
    static int xor(int a){
        if (a % 4 == 0) {
            return a;
        } if (a % 4 == 1) {
            return 1;
        } if (a % 4 == 2) {
            return a+1;
        }
        return 0;
    }
}
