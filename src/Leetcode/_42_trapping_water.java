package Leetcode;

//https://leetcode.com/problems/trapping-rain-water/submissions/1341600633/
public class _42_trapping_water {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(arr));
    }

    // TC : O(n)
    // optimal approach
    // intuition for this approach is, from left and right we can find the maximum and find the minimum between left and right maximum, now we know the water will depend on the min value, so fixing the right maximum and calculating the water and when we find leftMax > rightMax, we will fix leftMax and move from right to left to calculate the water
    public static int trap(int [] height){
        int n = height.length;
       int left = 0;
       int right = n -1;
       int leftMax = height[left];
       int rightMax = height[right];
       int water = 0;

       while(left < right){
           // height in left is smaller, so fixing the right max height, and calculating the water till we get left max greater than right max
           if(leftMax < rightMax){
                left++;
                leftMax = Math.max(leftMax, height[left]);
                water += leftMax - height[left];
           }
           // rightMax is smaller
           // fixing leftMax and calculating water
           else{
               right--;
               rightMax = Math.max(rightMax, height[right]);
               water += rightMax - height[right];
           }
       }
       return water;
    }




    // TC : O(n)
    // better approach
    public static int trap3(int [] height) {
        int n = height.length;
        int ans = 0;
        int [] leftMax = leftMax(height);
        int [] rightMax = rightMax(height);
        for (int i = 0; i < n; i++) {

            int prev = leftMax[i];
            int next = rightMax[i];
            int water = Math.min(prev, next);
            ans += water - height[i];
        }
        return ans;
    }

    // maximum in the right for all elements
    private static int[] rightMax(int[] height) {
        int [] ans = new int[height.length];
        int max = 0;
        for(int i = 0; i < height.length; i++){
            max = Math.max(max, height[i]);
            ans[i] = max;
        }
        return ans;
    }

    // maximum in the left for all elements
    private static int[] leftMax(int[] height) {
        int [] ans = new int[height.length];
        int max = 0;
        for(int i = height.length-1; i >= 0; i--){
            max = Math.max(max, height[i]);
            ans[i] = max;
        }
        return ans;
    }




    // TC : O(n*n)
    // brute force
    public static int trap2(int[] height) {
        int n = height.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            // finding maximum element in the left and right, taking minimum of them because water can only be stored till the min height, and then subtracting the current shell's height(space that the current shell occupies) from the minimum
            int prev = leftMax(height, i);
            int next = rightMax(height, i);
            int water = Math.min(prev, next);
            ans += water - height[i];
        }
        return ans;
    }

    // maximum element in the right of tar(index)
    private static int rightMax(int[] height, int tar) {
        int max = 0;
        for (int i = tar; i < height.length; i++) {
            max = Math.max(max, height[i]);
        }
        return max;
    }

    // maximum element in the left of tar(index)
    private static int leftMax(int[] height, int tar) {
        int max = 0;
        for (int i = 0; i <= tar; i++) {
            max = Math.max(max, height[i]);
        }
        return max;
    }
}
