package Assignment._05_arrays._01_easy;

import java.util.Arrays;

//https://leetcode.com/problems/shuffle-the-array/
public class _05_array_shuffle {
    public static void main(String[] args) {
//        int [] nums={1,2,3,4,5,6,7,8,9,10};
        int [] nums ={2,5,1,3,4,7};
        int n=(nums.length/2);
        System.out.println(n);
        int [] ans=arrayShuffle(nums,n);
        System.out.println(Arrays.toString(ans));
    }
    static int[] arrayShuffle(int [] nums ,int n){
        int []ans=new int[nums.length];
        int k,j;
        k=j=0;
        for(int i=0;i<nums.length;i++){
            if(i%2==0 || i==0){
                ans[k]=nums[j];
                k++;
                j++;
            }else{
                ans[k]=nums[n];
                n++;
                k++;
            }
        }
        return ans;
    }
}
