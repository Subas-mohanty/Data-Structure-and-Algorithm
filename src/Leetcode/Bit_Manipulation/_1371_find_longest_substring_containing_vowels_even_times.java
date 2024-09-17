package Leetcode.Bit_Manipulation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/description/?envType=daily-question&envId=2024-09-15

// this feels a hard question for me, here is the youtube explanation, solve it again after a while to understand the problem well
// https://www.youtube.com/watch?v=BI4h1IwfADs
// https://www.youtube.com/watch?v=6Xf5LfM-ciI

// I will write a bit what i have understand is
// first of all this can't be solved using sliding window, as we can't move the left pointer, but why ?
// ex - ellectabeoao , here the window condition is the window must have even number of vowels but how can we move left pointer when it is on e(1st index), because we don't know whether there is another e after the current window or not, and to get the longest substring we can't move the left without knowing that whether there is another e after the current window or not
// so how will it be solved ?
// the answer is bit masking.
// TODO : learn about bit masking

public class _1371_find_longest_substring_containing_vowels_even_times {
    public int findTheLongestSubstring(String s) {
        int n = s.length();

        // assign each vowel to a number so that we can perform xor operation
        // but why assign 1,2,4,8,16 , i don't get it
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 1);
        map.put('e', 2);
        map.put('i', 4);
        map.put('o', 8);
        map.put('u', 16);

        // this stores, when was the first time we saw the same mask
        int [] seen = new int[32];
        Arrays.fill(seen, -1);
        int mask = 0;
        int max_length = 0;

        // one more question will be how it is handling the case when we have odd number of vowels, for example lets's say our current mask is like this 00100, means we have 'i' odd number of time and it is also present in the seen array, means it is previously found so getting the length of that will be wrong as the substring itself is invalid as it has odd number of vowels, but no the substring doesn't have odd number of vowels, yes it had odd number of vowel when found previous thats why it has 1 in the mask but current we find another vowel and they will be even afer taking this odd vowel so it will make sure it always has even number of vowels
        for(int i = 0; i < n; i++){
            // calculating the mask for each vowel for consonant we are taking the map value as 0, so it will not affect the mask value
            mask = mask ^ map.getOrDefault(s.charAt(i), 0);

            // if we are seeing the mask value for first time then update the seen array or if we find it second or more time then calculate the max length
            if(mask != 0 && seen[mask] == -1) seen[mask] = i;
            else max_length = Math.max(max_length, i - seen[mask]);
        }
        return max_length;
    }


   public int findTheLongestSubstring2(String s) {
        Map<String, Integer> map = new HashMap<>();
        int [] state = new int[5];

        // at start we have state as all 0's and it is present at -1 index (for calculation)
        String currState = "00000";
        map.put(currState, -1);

        int result = 0;

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == 'a') state[0] = (state[0] + 1) % 2;
            else if (ch == 'e') state[1] = (state[1] + 1) % 2;
            else if (ch == 'i') state[2] = (state[2] + 1) % 2;
            else if (ch == 'o') state[3] = (state[3] + 1) % 2;
            else if (ch == 'u') state[4] = (state[4] + 1) % 2;

            // build the current state in a string format from the state array
            currState = Arrays.toString(state);
            currState = currState.replaceAll("[\\[\\],\\s]", "");

            // if it is present in the map, means we have seen this state before so get the length 
            if(map.containsKey(currState)){
                result = Math.max(result, i - map.get(currState));
            }
            // if we didn't find then simply add it to the map
            else map.put(currState, i);

        }
        return result;
    }
}
