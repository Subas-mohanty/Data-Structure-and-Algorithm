package Lecture_practice_problems._25_math_for_DSA_01;

public class _06_nth_magic_number {
    public static void main(String[] args) {
        int n=5;
        int ans=0;
        int base=5;
        while(n>0){
            int last=n&1;
            n=n>>1;
            ans+=last*base;
            base*=5;
        }
        System.out.println(ans);
    }
}
