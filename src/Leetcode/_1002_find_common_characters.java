package Leetcode;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/find-common-characters/solutions/5260643/faster-less-mem-detailed-approach-brute-force-python-java-c/?envType=daily-question&envId=2024-06-05
public class _1002_find_common_characters {
    public List<String> commonChars(String[] words) {
        List<String> ans = new ArrayList<>();

        // Loop through each character from 'a' to 'z'
        for(char ch = 'a'; ch <= 'z'; ch++){
            int min = Integer.MAX_VALUE;

            // Count occurrences of the current character in each word
            for(String word : words){
                int count = 0;
                for(char c : word.toCharArray()){
                    if(c == ch) count++;
                }
                // taking the minimum because if a character appears one time in a word and two or three time in all other words then we have to take it only once
                min = Math.min(min, count);
            }

            // Add the character to the result list the required number of times
            for(int i = 0; i < min; i++) ans.add(ch + "");
        }
        return ans;
    }
}
