package Lecture_practice_problems._25_math_for_DSA_01;

public class _07_digits_in_base {
    public static void main(String[] args) {
        int n=2;
        int b=2;
        int ans=(int)(Math.log(n)/Math.log(b))+1;
        System.out.println(ans);
    }
}
