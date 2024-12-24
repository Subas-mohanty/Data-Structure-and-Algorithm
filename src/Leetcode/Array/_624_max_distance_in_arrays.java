package Leetcode.Array;

import java.util.List;
//https://leetcode.com/problems/maximum-distance-in-arrays/solutions/5643319/easy-and-clean-code-c-java/?envType=daily-question&envId=2024-08-16
public class _624_max_distance_in_arrays {

    // TC : O(n)
    public int maxDistance(List<List<Integer>> arrays) {
        int small = arrays.getFirst().getFirst();
        int large = arrays.getFirst().getLast();
        int ans = 0;
        for(int i = 1; i < arrays.size(); i++){
            List<Integer> list = arrays.get(i);
            // getting the max distance current array's greatest and previous small
            ans = Math.max(ans, list.getLast() - small);

            // diff between current small and previous large
            ans = Math.max(ans, large - list.getFirst());

            // updating small and large
            small = Math.min(small, list.getFirst());
            large = Math.max(large, list.getLast());
        }
        return ans;
    }
}
