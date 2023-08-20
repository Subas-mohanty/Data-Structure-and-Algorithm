package Assignment._05_arrays._01_medium;

public class _08_sorted_array {
    public static void main(String[] args) {
        int [] arr ={1,2,3,4,5,6,7};
        rotate(arr,2);
        // not solved
    }
    static void rotate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            int last=nums.length-1-i;
            nums[0]=nums[last];
            nums[i]=nums[i+1];
        }
    }
}
