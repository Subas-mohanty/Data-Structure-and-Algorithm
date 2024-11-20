package Leetcode.Sliding_Window;
//https://leetcode.com/problems/take-k-of-each-character-from-left-and-right/description/?envType=daily-question&envId=2024-11-20
//https://www.youtube.com/watch?v=s4nRUC1SDDA&t=526s

public class _2516_take_k_of_each_character {
    public static void main(String[] args) {
        String s = "aabaaaacaabc";
        System.out.println(takeCharacters(s, 2));
    }

    // brute force recursion solution
    // TC : O(2^n)
    // SC : O(n)
    public static int takeCharacters2(String s, int k) {
        int ans = helper(s, new int[3], k);
        return ans >= (int)1e9 ? -1 : ans;
    }
    static int helper(String s, int [] arr, int k){
        if(s.isEmpty()) return (int)1e9;
        if(arr[0] >= k && arr[1] >= k && arr[2] >= k) return 0;
        arr[s.charAt(0) - 'a']++; // increasing the frequency of the character we take, left character
        int left = 1 + helper(s.substring(1), arr, k);
        arr[s.charAt(0) - 'a']++; // reducing the frequency , because the left call is over
        arr[s.charAt(s.length() - 1) - 'a']++;
        int right = 1 + helper(s.substring(0, s.length() - 1), arr, k);
        arr[s.charAt(s.length() - 1) - 'a']--;

        return Math.min(left, right);
    }


    // TC : O(n)
    // SC : O(1)
    public static int takeCharacters(String s, int k) {
        int n = s.length();

        int [] arr = new int[3];
        for(char ch : s.toCharArray()) arr[ch - 'a']++;
        if(arr[0] < k || arr[1] < k || arr[2] < k) return -1;

        // finding the window, jisse rakhke baki elements ko delete karde to we will get k of each character
        // think it of like this
        // aabaaaacaabc
        //     i j, move i to left and j to right, till where frequency of a,b and c is >= k,
        // here we are doing the same, right pointer moves everytime and for every right index, we are finding what would be the left index, and getting the max window size that needs to stay
        int left = 0, remainLen = 0;
        for (int right = 0; right < n; right++) {
            char ch = s.charAt(right);
            arr[ch - 'a']--; // when we move right, frequency of the character will reduce, so that we know when to move the left pointer, when the frequency of any character is < k

            while(arr[0] < k || arr[1] < k || arr[2] < k){
                arr[ch - 'a']++;
                left++; // moving the left pointer forward and adding the character frequency
            }
            // max window that will stay in the middle
            remainLen = Math.max(remainLen, right - left + 1);
        }
        return n - remainLen;
    }
}
