package Leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
//https://leetcode.com/problems/next-greater-element-ii/description/
public class _503_next_greater_element_2 {
    public static void main(String[] args) {
        int [] nums = {1,2,3,4,3};
        System.out.println(Arrays.toString(nextGreaterElements(nums)));
    }

    // TC : O(2*n)
    // SC : O(n) --> for the stack
    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int [] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i = 2*n -1 ; i>= 0; i--){
            // if a lesser value than the current element found in the stack top , then remove it
            while(!stack.isEmpty() && stack.peek() <= nums[i%n]) stack.pop();
            // this check is for, we will be storing answer for only n elements not more than n, because we are taking 2*n elements two calculate the problem
            if(i < n){
                if(!stack.isEmpty()){
                    ans[i] = stack.peek();
                }
                else{
                    ans[i] = -1;
                }
            }
            stack.push(nums[i%n]);
        }
        return ans;
    }


    public static int[] nextGreaterElements2(int[] nums) {
        int n = nums.length;
        int [] ans = new int[n];
        int ind = 0;
        for(int i = 0; i< n; i++){
            int greater = findGreater(i, nums);
            ans[ind++] = greater;
        }
        return ans;
    }
    public static int findGreater(int ind, int [] nums){
        int n = nums.length;
        int i;
        for(i = ind; i<n; i++){
            if(nums[i] > nums[ind]){
                return nums[i];
            }
        }
        if(i == n){
            for(int j = 0; j<ind; j++){
                if(nums[j] > nums[ind]){
                    return nums[j];
                }
            }
        }
        return -1;
    }




    // find previous smaller element(no cycle)
    public static int[] prevSmaller(ArrayList<Integer> A) {
        Stack<Integer> stack = new Stack<>();
//        ArrayList<Integer> list = new ArrayList<>();

        int [] ans = new int [A.size()];
        for(int i = 0; i < A.size(); i++){
            while(!stack.isEmpty() && stack.peek() >= A.get(i)) stack.pop();
            if(!stack.isEmpty()){
//                list.add( stack.peek());
                ans[i] = stack.peek();
            }
            else{
//                list.add(-1);
                ans[i] = -1;
            }
            stack.push(A.get(i));
        }
//        return list;
        return ans;
    }
}
