package Leetcode.Strings;

import java.util.Arrays;
import java.lang.StringBuilder;

public class _179_largest_number {
    // sort the array according to the first digit of the number from right to left
    // since we can't sort an integer array like this, we have to make it a string array
    // check for two strings a,b if a+b > b+a (ex : 5,9  95 > 59) then take a else take b
    // concatenate the result using a string builder

    // TC : O(n+n+nlogn)
    // SC : O(n)
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String [] arr = new String[n];
        for(int i = 0; i < n; i++){
            arr[i] = String.valueOf(nums[i]);
        }

        // what it will do is, it will take two strings a, b
        // and it will compare a+b with b+a, if b+a > a+b, then it will swap a,b else it will not swap
        // so that the larger value will be at first
        Arrays.sort(arr, (a,b) -> (b+a).compareTo(a+b));

        // if the largest value in the array is 0, that means all the values is 0, so return 0
        if(arr[0] == "0") return "0";

        // this will be slower than stringbuilder
        // return String.join("", arr);

        // concatenate the array and make the string
        StringBuilder sb = new StringBuilder();
        for(String s : arr) sb.append(s);

        return sb.toString();
    }
}
