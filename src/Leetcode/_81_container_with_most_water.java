package Leetcode;
//https://leetcode.com/problems/container-with-most-water/
public class _81_container_with_most_water {
    public static void main(String[] args) {
        int [] height = {1,2,1};
        System.out.println(maxArea(height));
    }
    // TC : O(n)
    // SC : O(1)

    // taking two pointer, one at start and second one at end,
    // which one is small, we calculate the water capacity of it, and move the pointer one step ahead
    public static int maxArea(int[] height) {
        int  max = 0;
        int n = height.length;
        int left = 0;
        int right = height.length-1;

        while(left <= right){
            int min = Math.min(height[left] , height[right]);
            int water = min * (right - left);
            if(min == height[left]) left++;
            else right--;
            max = Math.max(max, water);
        }
        return max;
    }
}
