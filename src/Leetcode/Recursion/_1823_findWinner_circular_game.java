package Leetcode.Recursion;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/find-the-winner-of-the-circular-game/?envType=daily-question&envId=2024-07-08
public class _1823_findWinner_circular_game {
    // TC : O(n)
    // SC : O(n)
    public int findTheWinner(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++) list.add(i);

        int ind = 0;
        while(list.size() > 1){
            int ind_to_remove = (ind + k - 1) % list.size();
            list.remove(ind_to_remove);
            ind = ind_to_remove;
        }
        return list.getFirst();
    }

    public int recursion(int n, int k){
        if(n == 1) return 1;

        int res = recursion(n-1, k) + k;
        return res % n == 0 ? n : res % n;
    }
}
