package Leetcode.Array;

import java.util.HashMap;
import java.util.Map;
//https://leetcode.com/problems/check-if-n-and-its-double-exist/description/?envType=daily-question&envId=2024-12-01

public class _1346_check_if_n_and_its_double_exits {

    // TC : O(N)
    // SC : O(1)
    public boolean checkIfExist2(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++) {
                // index of the element and its double element can't be equal
                if(i != j && arr[j] * 2 == arr[i]) return true;
            }
        }
        return false;
    }
    // TC : O(N)
    // SC : O(n)
    public boolean checkIfExist(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        for(int i = 0; i < n; i++) map.put(arr[i], i);
        for(int i = 0; i < n; i++){
            // index of the element and its double element can't be equal
            if(map.containsKey(2 * arr[i]) &&  map.get(2 * arr[i]) != i) return true;
        }
        return false;
    }
}
