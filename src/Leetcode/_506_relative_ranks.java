package Leetcode;
import java.util.Arrays;
import java.util.Collections;
//https://leetcode.com/problems/relative-ranks/description/?envType=daily-question&envId=2024-05-08
public class _506_relative_ranks {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        Integer [] sorted = new Integer[n];
        for(int i = 0; i < n; i++){
            sorted[i] = score[i];
        }
        Arrays.sort(sorted, Collections.reverseOrder());

        String [] ans = new String[n];
        for(int i = 0; i < n; i++){
            if(score[i] == sorted[0]) ans[i] = "Gold Medal";
            else if(score[i] == sorted[1]) ans[i] = "Silver Medal";
            else if(score[i] == sorted[2]) ans[i] = "Bronze Medal";
            else {
                int index = indexOf(sorted, score[i]);
                ans[i] = index+1 + "";
            }
        }
        return ans;
    }
    public int indexOf(Integer [] arr, int key){
        for(int i = 0; i< arr.length; i++){
            if(arr[i] == key) return i;
        }
        return -1;
    }
}
