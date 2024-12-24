package Lecture_practice_problems_kunal_kushwaha._26_maths_for_DSA_02;

import java.util.ArrayList;

public class _05_factors {
    public static void main(String[] args) {
        factors3(12);
    }
    // Time complexity : O(n)
    static void factors(int n){
        for (int i = 1; i <= n; i++) {
            if(n%i==0){
                System.out.print(i+" ");
            }
        }
    }
    // Time complexity : O(sqrt(n))
    static void factors2(int n){
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if(n%i==0){
                if (n / i == i) {
                    System.out.print(i+" ");
                } else{
                    System.out.print(i+" "+n/i+" ");
                }
            }
        }
    }

    // Both time and space complexity will be O(sqrt(n))
    static void factors3(int n){
        ArrayList<Integer> list=new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if(n%i==0){
                if (n / i == i) {
                    System.out.print(i+" ");
                } else{
                    System.out.print(i+" ");
                    list.add(n/i);
                }
            }
        }
        for (int i = list.size()-1; i >= 0; i--) {
            System.out.print(list.get(i)+" ");
        }
    }
}
