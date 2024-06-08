package Leetcode;

import java.util.Arrays;
import java.util.HashMap;
//https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/
//https://leetcode.com/problems/hand-of-straights/submissions/1279855696/?envType=daily-question&envId=2024-06-06
class _1296_divideArray_set_of_k_consecutive{
    public boolean isPossibleDivide(int[] hand, int gr) {
        int n = hand.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        if(n % gr != 0) return false;
        Arrays.sort(hand);
        for(int a : hand){
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        for(int a : hand){
            // if frequency of a is greater than 0 , only then we will continue
            if(map.get(a) > 0){
                for(int i = 0; i < gr; i++){

                    // checking for consecutive numbers
                    int curr = a + i;
                    if(map.getOrDefault(curr, 0) > 0){
                        map.put(curr, map.get(curr) - 1);
                    }
                    else return false;
                }
            }
        }
        return true;
    }
}
