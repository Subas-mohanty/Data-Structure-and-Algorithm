package Assignment._05_arrays._01_easy;

import java.util.Arrays;

//https://leetcode.com/problems/find-the-highest-altitude/
public class _12_highest_altitude {
    public static void main(String[] args) {
        int [] arr={-5,1,5,0,-7};
        int ans=highestAltitude(arr);
        System.out.println(ans);
    }
    static int highestAltitude(int[] gain){
        int [] ans=new int[gain.length+1];
        int sum=0;
        ans[0]=0;
        for (int i = 0; i <gain.length ; i++) {
            ans[i]=sum;
            sum+=gain[i];
        }
        ans[gain.length]=sum;
        return gain(ans);
    }
    static int gain(int [] arr){
        int max=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>max){
                max=arr[i];
            }
        }
        return max;
    }
}
