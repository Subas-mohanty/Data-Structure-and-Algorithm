package Leetcode.Strings;

import java.util.ArrayList;
//https://leetcode.com/problems/find-the-closest-palindrome/?envType=daily-question&envId=2024-08-24
//https://www.youtube.com/watch?v=tF9VhkSDaSI&t=1063s
public class _564_find_the_closest_palindrome {

    // TC : O(1 + 3* log10(n)) --> 2 constant case and 3 function call each, log10(n)
    // SC : O(1)
    public String nearestPalindromic(String n) {
        // we can use long [] of size 5 here
        ArrayList<Long> list = new ArrayList<>();
        int len = n.length();
        boolean isOdd = len % 2 != 0;

        // for even 1221, mid will be 1, and while using substring we should pass 2(len/2);
        // for odd 12321, mid will be len/2 + 1
        int mid = (len % 2 == 0) ? len/2 : len/2 + 1;

        // copy first half
        long firstHalf = Long.parseLong(n.substring(0, mid));

        // for any number, check for these five cases and find which number is closest to the given number
        // all these cases will give a palindrome number, because we are converting the number to palindrome using these five cases

        list.add(findNearestPalindrome(firstHalf, isOdd)); // for 123 , firstHalf = 12, res = 121
        list.add(findNearestPalindrome(firstHalf + 1, isOdd)); // for 123, firstHalf = 13, res = 131
        list.add(findNearestPalindrome(firstHalf - 1, isOdd)); // for 123, firstHalf = 11, res = 111

        list.add((long)Math.pow(10, len-1) - 1); // all 9's
        list.add((long)Math.pow(10, len) + 1); // 101, 1001, 10001... cases

        long num = Long.parseLong(n);
        long minDiff = Long.MAX_VALUE;
        long res = Long.MAX_VALUE;

        // finding the element in the list which is closest to given number(n)
        for(long element : list){
            if(element == num) continue; // if the element is same as num then don't take it(told in the question)

            long currDiff = Math.abs(element - num);
            if(currDiff < minDiff){
                res = element;
                minDiff = currDiff;
            }
            else if(currDiff == minDiff) res = Math.min(res, element);
        }
        return String.valueOf(res);
    }



    // this function copies the first half to the second half
    // for ex - 12 --> 1221 and for odd number 123, it removes the last digit 3 and copies the remaining, 12 --> 1221
    private long findNearestPalindrome(long firstHalf, boolean isOdd) {
        long res = firstHalf;
        if(isOdd){
            firstHalf /= 10;
        }
        while(firstHalf > 0){
            res = res * 10 + (firstHalf % 10);
            firstHalf /= 10;
        }
        return res;
    }
}
