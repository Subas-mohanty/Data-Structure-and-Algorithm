package Leetcode.DP;
import java.lang.StringBuilder;
import java.util.Map;
import java.util.HashMap;

// https://leetcode.com/problems/count-ways-to-build-good-strings/submissions/1492330276/?envType=daily-question&envId=2024-12-30

public class _2466_count_ways_to_build_good_string {
    // TC : O(2 ^ high) 
    // SC : O(high) --> for the recursion
    // we are using global variable here, we can also use int helper() and return the value from it
    // but think how will you memotize it ?
    // u will say, i will take a map of <string, int> and store the size of sb and the count
    // but this will not work as sb is changing in every function call
    // so we have to use another variable length to track the length of the sb and map it with the count
    public int countGoodStrings(int low, int high, int zero, int one) {
        helper(low, high, zero, one, new StringBuilder());
        return count;
    }
    int count;

    void helper(int low, int high, int zero, int one, StringBuilder sb){
        if(sb.length() >= low && sb.length() <= high) {
            count++;
            count %= (int)1e9 + 7;
        }
        if(sb.length() > high) return;

        for(int i = 0; i< zero; i++) sb.append("0");
        helper(low, high, zero, one, sb);
        sb.delete(sb.length() - zero, sb.length());

        for(int i = 0; i< one; i++) sb.append("1");
        helper(low, high, zero, one, sb);
        sb.delete(sb.length() - one, sb.length());
    }


    // TC : O(high) --> the string length can go upto maximum high
    // SC : O(high) --> for the map
    // when we are using length, we don't actually need the string, we can directly update the length variable
    // and here is how we are doing it
    public int countGoodStrings2(int low, int high, int zero, int one) {
        return helper2(low, high, zero, one, 0, (int)1e9 + 7);
    }
    Map<Integer, Integer> map = new HashMap<>();

    int helper2(int low, int high, int zero, int one, int length, int mod){
        if(length > high) return 0;

        int count = 0;
        if(length >= low && length <= high) count = 1;

        if(map.containsKey(length)) return map.get(length);

        count += helper2(low, high, zero, one, length + zero, mod);
        count %= mod;

        count += helper2(low, high, zero, one, length + one, mod);
        count %= mod;
        map.put(length, count);
        return count;
    }
}
