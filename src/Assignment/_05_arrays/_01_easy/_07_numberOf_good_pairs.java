package Assignment._05_arrays._01_easy;

public class _07_numberOf_good_pairs {
    public static void main(String[] args) {
        int [] arr={1,2,3,1,1,3};
        System.out.println(numIdenticalPairs(arr));
    }
    static int numIdenticalPairs(int[] nums) {
        int count=0;
        for(int j=0;j<nums.length;j++){
            for(int i=0;i<j;i++){
                if(nums[i]==nums[j]){
                    count++;
                }
            }
        }
        return count;
    }
}
