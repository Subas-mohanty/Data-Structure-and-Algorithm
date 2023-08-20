package Leetcode;

public class _01_single_number2 {
    public static void main(String[] args) {
        int [] arr={2,2,3,2};
        int ans=singleNumber(arr);
        System.out.println(ans);

    }
    static int singleNumber(int[] nums) {
        int ans=0;
        for (int i = 0; i < 32; i++){ // here 32 is used because max bit available in int is 32
            int sum=0;
            for (int j = 0; j < nums.length; j++) {
                if(((nums[j]>>i)&1)==1){ // if the right set bit is one for every iteration than we increment the sum by one
                    sum++;
                }
            }
            sum%=3;
            // now for every index bits we have to do the same to find the unique number
            if (sum != 0) {
                ans|=sum<<i;
            }
        }
        return ans;
    }
}
