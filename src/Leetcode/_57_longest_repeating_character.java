package Leetcode;

//https://leetcode.com/problems/longest-repeating-character-replacement/description/
public class _57_longest_repeating_character {
    public static void main(String[] args) {
        String s = "ABCABC";
        int k = 2;
        System.out.println(helper(s, k));
    }

    // TC : O(N)
    // SC : O(1)
    public static int helper(String s, int k) {
        // this is a frequency array we will be storing the frequency of each character of string s in this array
        int[] arr = new int[26];
        int left = 0;
        int res = 0; // ans
        int max = 0; // max frequency of a character in a window
        for (int right = 0; right < s.length(); right++) {
            arr[s.charAt(right) - 'A']++; // increasing the frequency of the current character

            max = Math.max(max, s.charAt(right) - 'A'); // checking which max value any character in that window have

            // right-left+1 = size of the window, if the length - max frequency of that window is greater than the allowed limit , K . This means that we have to change that many(length - max) character to make the window valid but we can't do that as we can change at most k character
            if (right - left + 1 - max > k) {
                arr[s.charAt(left) - 'A']--; // decreasing the frequency of the character at left pointer
                left++; // moving the left pointer forward
            }

            // taking the max valid window size
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
