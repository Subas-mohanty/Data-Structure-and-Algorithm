package Leetcode;
//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class _53_longest_unique_substring {
    // TC : O(n) as we are visiting each element only once, and the average time complexity for finding element in map is O(1)
    // SC : O(n) , for the Map
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 1) return 1;
        int left = 0;
        int right = 0;
        int length = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        while(right < s.length()){
            char ch = s.charAt(right);
            if(map.containsKey(ch)){
                int ind = map.get(ch);
                map.remove(ch);
                left = Math.max(ind+1, left);
            }
            else{
                map.put(s.charAt(right), right);
                right++;
                length = Math.max(length, right-left);
            }
        }
        return length;
    }

    // TC : O(2n) --> as we are visiting each element twice, once by the right pointer and once by the left pointer
    // SC : O(n) --> for the set
    public int lengthOfLongestSubstring2(String s) {
        if(s.length() == 1) return 1;
        int left = 0;
        int right = 0;
        int length = 0;
        HashSet<Character> set = new HashSet<>();

        while(right < s.length()){
            char ch = s.charAt(right);
            if(set.contains(ch)){
                set.remove(s.charAt(left));
                left++;
            }
            else{
                set.add(s.charAt(right));
                right++;
                length = Math.max(length, right-left);
            }
        }
        return length;
    }

    // this is to find the length of the longest subsequence not substring
    public int lengthOfLongestSubSequences(String s){
        HashSet<Character> set = new HashSet<>();
        char [] arr = s.toCharArray();

        for(int i = 0 ; i<arr.length; i++){
            set.add(arr[i]);
        }
        String ans = "";
        Iterator<Character> itr = set.iterator();
        while(itr.hasNext()){
            ans+=itr.next();
        }
        return ans.length();
    }
}
