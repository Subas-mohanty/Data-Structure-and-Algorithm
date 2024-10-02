package Leetcode.Array;

import java.util.*;

//https://leetcode.com/problems/rank-transform-of-an-array/submissions/1409171876/?envType=daily-question&envId=2024-10-02

public class _1331_rank_transform_of_array {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int [] ans = new int[n];
        Set<Integer> set = new HashSet<>();
        for(int a : arr) set.add(a);
        List<Integer> list = new ArrayList<>(set);
//        List<Integer> list = new ArrayList<>();
//        for(int a : set) list.add(a);

        Collections.sort(list);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < list.size(); i++){
            map.put(list.get(i), i+1);
        }
        for(int i = 0; i < n; i++){
            ans[i] = map.get(arr[i]);
        }
        return ans;
    }

    // TC : O(n + nlogn + n)
    // SC : O(n + n)
    public int[] arrayRankTransform2(int[] arr) {
        int n = arr.length;
        int [] ans = new int[n];
        int [] temp = arr.clone(); // copy the elements of arr to temp

        Arrays.sort(temp);

        int ind = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            if(!map.containsKey(temp[i])) {
                map.put(temp[i], ind++);
            }
        }
        for(int i = 0; i < n; i++){
            ans[i] = map.get(arr[i]);
        }
        return ans;
    }
}
