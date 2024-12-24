package Leetcode.Strings;

// https://leetcode.com/problems/minimum-deletions-to-make-string-balanced/description/

//https://www.youtube.com/watch?v=dkaEBlvjxA8
public class _1653_min_deletions_to_make_string_balanced {

    // TC : O(n)
    // SC : O(2*n)
    public int minimumDeletions(String s) {
        int n = s.length();
        int [] aCount = new int[n];
        int [] bCount = new int[n];

        // counting number of b's in the left side of every index
        for(int i = 1; i < n; i++){
            char ch = s.charAt(i-1);
            aCount[i] = aCount[i-1];
            if(ch == 'b') aCount[i]++;
        }

        // counting number of a's in the right side of every index
        for(int i = n-2; i >= 0; i--){
            char ch = s.charAt(i+1);
            bCount[i] = bCount[i+1];
            if(ch == 'a') bCount[i]++;
        }

        int min = (int)1e9;
        for(int i = 0; i < n; i++){
            min = Math.min(min, aCount[i] + bCount[i]);
        }
        return min;
    }
}
