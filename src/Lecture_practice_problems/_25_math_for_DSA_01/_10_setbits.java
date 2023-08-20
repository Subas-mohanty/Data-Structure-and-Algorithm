package Lecture_practice_problems._25_math_for_DSA_01;

public class _10_setbits {
    public static void main(String[] args) {
        int n=6;

        System.out.println(Integer.toBinaryString(n)); // this shows the binary representation of a number
        System.out.println(setbits(n));
    }

    private static int setbits(int n) {
        int count=0;
        while (n > 0) {
            count++;
            n-=(n & (-n));
        }
        return count;
    }
}
