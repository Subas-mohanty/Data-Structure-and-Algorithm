package Leetcode.DP;

import java.util.HashMap;
import java.util.Map;
//https://leetcode.com/problems/decode-ways/
public class _91_decode_ways {
    Map<String, Integer> map = new HashMap<>();
    public int numDecodings(String s) {
        return helper(s);
    }
    // TC : O(N) --> we can split s in n ways
    // SC : O(N)
    int helper(String s){
        // the string is empty means we visit the whole string and find a way to decode
        if(s.isEmpty()) return 1;

        // if the string starts from 0, then we can't find any valid code, because we have only two options, either we take 0 and x separately which is wrong because for 0 there is no mapping, another option is take 0x(combined), and it is also wrong, as no mapping is there
        if(s.charAt(0) == '0') return 0;

        if(map.containsKey(s)) return map.get(s);

        // take one character
        int ans = helper(s.substring(1));
        // take two character and check if the string is of length 2 or more and the code should be under 26
        if(s.length() >= 2 && Integer.parseInt(s.substring(0, 2)) <= 26) ans += helper(s.substring(2));
        map.put(s, ans);
        return ans;
    }
}
