package Leetcode;

import java.util.Arrays;
import java.util.HashMap;
//https://shorturl.at/TMYIc
public class _90_replace_elements_by_rank {
    static int[] replaceWithRank(int arr[], int N) {
        // code here

        HashMap<Integer, Integer> map = new HashMap<>();
        int n = arr.length;


        int [] sorted = new int[n];
        for(int i = 0; i < n; i++) sorted[i] = arr[i];
        Arrays.sort(sorted);

        int rank = 1;
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(sorted[i])) {
                map.put(sorted[i], rank++);
            }
        }

        int [] ans = new int[n];
        for(int i= 0; i < n; i++){
            ans[i] = map.get(arr[i]);
        }
        return ans;
    }
}
