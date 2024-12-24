package Leetcode.Strings;
//https://leetcode.com/problems/sum-of-beauty-of-all-substrings/
public class _1781_sum_of_beauty_of_substring {
    // TC : O(n^2) * 26
    // SC : O(26) || O(1)
    public int beautySum(String s) {
        int ans = 0;
        int n = s.length();
        for(int i = 0; i < n; i++){
            int [] fr = new int[26]; // storing the frequency of characters
            for(int j = i; j < n; j++){
                fr[s.charAt(j) - 'a']++; // incrementing the frequency
                ans += freqDiff(fr);
            }
        }
        return ans;
    }

    // this is finding the maximum and minimum frequency of the array, or the difference between the maximum and the minimum element in the array
    public int freqDiff(int [] fr){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < fr.length; i++){
            // ignoring 0, because if we take 0, it may result to wrong answer
            // but how can 0 be present in the array as we are updating according to every character, here is an example
             /* For i = 0:

            j = 0: Substring = "a", fr = [1, 0, 0, ..., 0]
            j = 1: Substring = "ab", fr = [1, 1, 0, ..., 0]
            j = 2: Substring = "abc", fr = [1, 1, 1, ..., 0]
            For i = 1:

            j = 1: Substring = "b", fr = [0, 1, 0, ..., 0]
            j = 2: Substring = "bc", fr = [0, 1, 1, ..., 0]
            For i = 2:

            j = 2: Substring = "c", fr = [0, 0, 1, ..., 0]

            */
            if(fr[i] == 0) continue;

            min = Math.min(min, fr[i]);
            max = Math.max(max, fr[i]);
        }

        return max-min;
    }
}
