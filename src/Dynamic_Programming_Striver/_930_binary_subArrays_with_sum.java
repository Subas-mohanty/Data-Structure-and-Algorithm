package Dynamic_Programming_Striver;

public class _930_binary_subArrays_with_sum {

    public static void main(String[] args) {
        int [] arr = {1,0,1,0,1};
        int goal = 2;
        System.out.println(numSubarraysWithSum(arr, goal));
    }
    public static int numSubarraysWithSum(int[] nums, int goal) {
        int i = 0;
        int j = 0;
        int n = nums.length;
        int count = 0;

        while(i < n && j < n){
            int sum = findSum(nums, i, j);
            if(sum == goal){
                count++;
                if(j < n-1) j++;
                else {
                    i++;
                    j = i;
                }
            }
            if(sum < goal) j++;
            if(sum > goal){
                i++;
                j = i;
            }
        }
        return count;
    }
    public static int findSum(int [] nums, int s, int e){
        int sum = 0;
        for(int i = s; i<= e; i++) sum += nums[i];
        return sum;
    }
}
