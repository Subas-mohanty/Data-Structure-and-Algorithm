package Lecture_practice_problems._25_math_for_DSA_01;

public class _08_powOfTwo {
    public static void main(String[] args) {
        int n=32;
        boolean ans=(n&(n-1))==0;
        if(n==0){
            ans=false;
        }
        System.out.println(ans);
    }
}
