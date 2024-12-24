package Leetcode.Array;

import java.util.Arrays;
//https://leetcode.com/problems/plus-one/
public class _66_plus_one {
    public static void main(String[] args) {
        int [] arr={9,9,9};
        System.out.println(Arrays.toString(plusOne(arr)));
    }
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            // we are checking for the last element if it is less than 9 , then add 1 to it and just return the array
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            // if the last element is 9 then change it to 0, and add 1 to its previous element which is not equal to 9
            digits[i] = 0;
        }
        // if the number is like 9, 99 or 999 then this will execute when adding 1 will create 1 more digits
        digits = new int[digits.length + 1]; // if this runs that means the number has all 9 in it, so we have all the elements as 0 in the digits array so when we initialize again it doesn't change anything as int array is initialized with 0 by default, and at the beginning just add another 1 for the extra digit.
        digits[0] = 1;
        return digits;
    }
}
