package Leetcode.Graph;

import java.util.Arrays;
//https://leetcode.com/problems/find-champion-ii/description/?envType=daily-question&envId=2024-11-26

public class _2924_find_champion_2 {

    // TC : O(n)
    // SC : O(n)
    public int findChampion(int n, int[][] edges) {
        Integer [] great = new Integer[n];
        Arrays.fill(great, -1);
        // counting nodes with indegree 0
        for(int [] arr : edges){
            great[arr[1]]++;
        }
        int count = 0;
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(great[i] == -1){
                ans = i;
                count++;
                if(count >= 2) return -1;
            }
        }
        return ans;
    }
}
