package Leetcode.Strings;

import java.util.Arrays;
//https://leetcode.com/problems/find-the-kth-largest-integer-in-the-array/submissions/
public class _1985_find_kth_largest_in_string_array {

    // understand about comparator a little bit, like how the value are returns
    // todo : and remember that for sorting in decreasing order we have to modify and return 1 in place of -1 and -1 instead of 1
    public static void main(String[] args) {
        String [] nums = {"423","521","2","42"};
        int k = 2;
        System.out.println(kthLargestNumber(nums, k));
//        System.out.println(larger("423", "521"));
    }
    public static String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums, (a, b) -> {
            // b has more digits than a, so swap it, because b is bigger
            if(b.length() > a.length()) return 1;

                // if both b and a has same number of digits then check for each digit in both the strings and find the larger one
            else if(a.length() == b.length()){
//                return b.compareTo(a); // why not a.compareTo(b) , because we are sorting in decreasing order
                return larger(a,b); // this will return 1 or -1, based on which is larger, if b is larger, then it will return 1 so that a and b both swapped, if a is greater, then it will return -1, means no swap is needed
            }
            // if above two conditions doesn't match, means no swapping needed, so return -1
            return -1;
        });
        System.out.println(Arrays.toString(nums));
        return nums[k-1];
    }



    // this will sort in increasing order, to sort in creasing we have to swap position of a and b
//    Arrays.sort(nums, (a, b) -> {
//        // b has more digits than a, so swap it, because b is bigger
//        if(a.length() != b.length()) return a.length - b.length;
//        return a.compareTo(b);
//    });



    static int larger(String a, String b){
        int n = a.length();
        for(int i = 0; i < n; i++){

            // if we find at any place the digit in b is greater than a, means b is greater so swap
            if(b.charAt(i)  > a.charAt(i) ) return 1;
            if(a.charAt(i) > b.charAt(i)) return -1;
        }
        return 0;
    }
}
