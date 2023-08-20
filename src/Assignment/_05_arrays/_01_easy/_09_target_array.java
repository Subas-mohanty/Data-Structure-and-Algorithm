package Assignment._05_arrays._01_easy;
//not solved yet
import java.util.Arrays;

//https://leetcode.com/problems/create-target-array-in-the-given-order/
public class _09_target_array {
    public static void main(String[] args) {
        int[] nums ={0,1,2,3,4};
        int[] index ={0,1,2,2,1};
        int [] ans=createTargetArray(nums,index);
        System.out.println(Arrays.toString(ans));
    }
    static int[] createTargetArray(int[] nums, int[] index) {
        int [] target=new int[nums.length];
        for(int i=0;i<nums.length;i++){
//            target(index[i],nums[i]);
        }
        return target;
    }
}
