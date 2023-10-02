package Leetcode;

public class _13_AverageValue {
    public int averageValue(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int count=0;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            // The number which is divided by 6 is divided by both 2 and 3 so it is even as well as divisible by 3
            if(nums[i]%6==0){
                count++;
                sum+=nums[i];
            }
        }
        // if any such number is not present
        if(count==0){
            return 0;
        }
        return sum/count;
    }
}
