package Assignment._07_sorting._01_easy;

//https://leetcode.com/problems/missing-number/
//Amazon interview question
public class _04_missing_number {
    public static void main(String[] args) {
        int [] arr={3,0,1};
        int ans=missingNumber(arr);
        System.out.println(ans);
//        missingNumber(arr);
//        System.out.println(Arrays.toString(arr));
    }
    static int missingNumber(int[] nums) {
        int i=0;
        while(i<nums.length){
            if(nums[i]<nums.length && i!=nums[i]){
                swap(nums,i,nums[i]);
            }
            else{
                i++;
            }
        }
        // this is to return the missing number
        for (int j = 0; j < nums.length; j++) {
            if(nums[j]!=j){ // 3,0,1 in this case after sorting 0,1,3 now all the values are on the right indexes so every value must be at index j and if it's not than that is the missing number and we return it
                return j;
            }
        }
        return nums.length; // else if all the values are on the right index , then all the numbers are present except the last one which value equal to the length of the array
    }

     static void swap(int[] nums, int first, int second) {
        int temp=nums[first];
        nums[first]=nums[second];
        nums[second]=temp;
    }
}
