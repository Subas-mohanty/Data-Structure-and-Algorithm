package Assignment._05_arrays._01_easy;

import java.util.Arrays;

public class _08_smallerNumber_than_current {
    public static void main(String[] args) {
        int [] arr={8,1,2,2,3};
        int [] count=smallerNumbersThanCurrent(arr);
        System.out.println(Arrays.toString(count));
    }
    static int[] smallerNumbersThanCurrent(int[] nums) {
        int [] count=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int no=0;
            for(int j=0;j<nums.length;j++){
                if(nums[j]<nums[i]){
                    no++;
                }
            }
            count[i]=no;
        }
        return count;
    }
}
