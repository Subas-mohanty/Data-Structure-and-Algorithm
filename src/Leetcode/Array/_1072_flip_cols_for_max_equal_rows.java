package Leetcode.Array;

import java.util.HashMap;
import java.util.Map;
//https://leetcode.com/problems/flip-columns-for-maximum-number-of-equal-rows/?envType=daily-question&envId=2024-11-22

// what we are doing here ?
// we are given a matrix and we are making each of its row to a pattern like this
// 0 1 0
// 0 0 1
// 1 0 1
// if this is the matrix then for each row the corresponding string will be like
// aba
// aab
// aba
// now which strings frequency is more, that will be our answer

public class _1072_flip_cols_for_max_equal_rows {

    // TC : O(n * m)
    // SC : O(n) --> size of row

    public int maxEqualRowsAfterFlips(int[][] matrix) {
//        Map<StringBuilder, Integer> map = new HashMap<>(); we can't use it like this, because the StringBuilder class doesn't have a equals and hashcode method implemented by default, so it will not check for the content of the string when comparing leading to incorrect result
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < matrix.length; i++){
            StringBuilder sb = new StringBuilder();
            sb.append("a");
            for(int j = 1; j < matrix[0].length; j++){
                // if the current char is equal to its prev char, append the same char as of previous
                if(matrix[i][j] == matrix[i][j-1]) sb.append(sb.charAt(sb.length() - 1));
                // if they are not equal then put a if the prev is b or vice versa
                else{
                    char ch = sb.charAt(sb.length() - 1);
                    if(ch == 'a') sb.append("b");
                    else sb.append("a");
                }
            }
            // put the string with updated frequency
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
        }
        int ans = 0;
        // finding the max frequency of a row converted string
        for(String s : map.keySet()){
            ans = Math.max(ans, map.get(s));
        }
        return ans;
    }
}
