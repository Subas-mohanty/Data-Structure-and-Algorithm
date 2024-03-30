package Leetcode;

import java.util.HashMap;
import java.util.Map;
//https://leetcode.com/problems/majority-element/description/
public class _62_majority_element {
    public static void main(String[] args) {
        int [] arr = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(arr));
    }

    // TC : O(n)
    // SC : O(n)
    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            int freq = map.getOrDefault(num, 0);
            map.put(num, freq+1);
        }
        for(Map.Entry<Integer, Integer>  entry : map.entrySet()){
            int k = entry.getKey();
            int count = map.get(k);
            if(count > nums.length/2) return k;
        }
        return -1;
    }

    // TC : O(n)
    // SC : O(1)
    public static int helper2(int [] nums){
        int ele = nums[0];
        int count = 1;

        for(int i = 0; i<nums.length; i++){
            if(nums[i] == ele) count++;
            else{
                count--;
                if(count == 0){
                    ele = nums[i];
                    count = 1;
                }
            }
        }
        return ele;
    }
}
