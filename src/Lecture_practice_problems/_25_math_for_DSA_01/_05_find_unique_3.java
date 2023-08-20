package Lecture_practice_problems._25_math_for_DSA_01;
//https://leetcode.com/problems/single-number-iii/
import java.util.Arrays;

public class _05_find_unique_3 {
    public static void main(String[] args) {
//        should be solved by bit operation but can't figure out how to do it
        int [] arr={1,2,1,3,2,5};
        int [] ans=findUnique(arr);
        System.out.println(Arrays.toString(ans));
    }
    static int[] findUnique(int [] arr){
        int xorans=0;
        for (int i = 0; i < arr.length; i++) {
            xorans^=arr[i]; // This will leave with XOR of the two distinct element
        }
        // Now we have to separate the xor to get the answer
        // for that we have to find the first setbit of the XOR
        // for that there is a formula i.e, x & ~(x-1)
        xorans=xorans & ~(xorans-1); // now we got the first setbit of the XOR ans

        int set1=0; // number with setbit as one will be stored in this, then by performing XOR with all elements we get the unique element in that set
        int set2=0; // number with setbit as zero will be stored in this, then by performing XOR with all elements we get the unique element in that set

        for (int i = 0; i < arr.length; i++) {
            if ((xorans & arr[i]) != 0) {
                set1^=arr[i];
            } else{
                set2^=arr[i];
            }
        }
        return new int[]{set1,set2};
    }
}
