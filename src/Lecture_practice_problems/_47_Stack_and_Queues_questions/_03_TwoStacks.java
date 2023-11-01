package Lecture_practice_problems._47_Stack_and_Queues_questions;

import java.util.Arrays;
import java.util.Scanner;

public class _03_TwoStacks {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int test_case=scanner.nextInt();
        for (int i = 0; i < test_case; i++) {
            int a_size=scanner.nextInt();
            int b_size=scanner.nextInt();
            int sum=scanner.nextInt();
            int [] a=new int[a_size];
            int [] b=new int[b_size];
            for (int j = 0; j < a_size; j++) {
                a[j]=scanner.nextInt();
            }
            for (int j = 0; j < b_size; j++) {
                b[j]=scanner.nextInt();
            }

            System.out.println(twoStacks(sum,a,b));
        }
    }
    public static int twoStacks(int s, int [] a, int [] b){
        return twoStacks(s, a, b, 0, 0) -1;
    }

    private static int twoStacks(int s, int[] a, int[] b, int sum, int count) {

        if(sum>s){
            return count;
        }
        if(a.length==0 || b.length==0){
            return count;
        }
        int left=twoStacks(s, Arrays.copyOfRange(a, 1,a.length),b,sum + a[0],count +1);
        int right=twoStacks(s, a, Arrays.copyOfRange(b, 1,b.length), sum + b[0],count +1);

        return Math.max(left,right);
    }
}
