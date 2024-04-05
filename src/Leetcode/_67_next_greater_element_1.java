package Leetcode;

import java.util.Arrays;
//https://leetcode.com/problems/next-greater-element-i/description/
public class _67_next_greater_element_1 {
    public static void main(String[] args) {
        int [] nums1 = {4,1,2};
        int [] nums2 = {1,3,4,2};
        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
    }
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        return helper(nums1, nums2);
    }
    public static int [] helper(int [] a, int [] b){
        int [] ans = new int[a.length];
        int index = 0;
        for(int num : a){
            int greaterElement = findGreater(num, b);
            ans[index++] = greaterElement;
        }
        return ans;
    }

    private static int findGreater(int num, int[] b) {
        int indexOfGreater = 0;
        for (int i = 0; i < b.length; i++) {
            if(b[i] == num){
                indexOfGreater = i;
                break;
            }
        }
        int greaterElement = (int)-1e8;
        for (int i = indexOfGreater; i < b.length; i++) {
            if(b[i] > num){
                greaterElement = b[i];
                break;
            }
        }
        return greaterElement == (int)-1e8 ? -1 : greaterElement;
    }

}
