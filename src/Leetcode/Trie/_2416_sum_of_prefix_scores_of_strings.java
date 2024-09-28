package Leetcode.Trie;
//https://leetcode.com/problems/sum-of-prefix-scores-of-strings/description/?envType=daily-question&envId=2024-09-25


import java.util.HashMap;
import java.util.Map;

public class _2416_sum_of_prefix_scores_of_strings {

    // gives TLE
    // TC : O(n * m^2 + n * m^2) --> the substring method take O(n) time
    // we can replace this with StringBuilder to reduce that time complexity, still give TLE
    // SC : O(n * m)
    public int[] sumPrefixScores2(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        int [] ans = new int[words.length];
        int ind = 0;

        for(String s : words){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < s.length(); i++){
                sb.append(s.charAt(i));
                map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            }
        }

        for(String s : words){
            int sum = 0;
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < s.length(); i++){
                sb.append(s.charAt(i));
                if(map.containsKey(sb.toString())){
                    sum += map.get(sb.toString());
                }
            }
            ans[ind++] = sum;
        }
        return ans;
    }



    // TC : O(n * m + n * m) --> n = words.length, m = length of longest word in words array
    // SC : O(n * m) --> for each word we are creating m trie with an array of length 26
    public int[] sumPrefixScores(String[] words) {
        int [] ans = new int[words.length];
        Trie trie = new Trie();

        for(String s : words){
            trie.insert(s);
        }

        for(int i = 0; i < words.length; i++){
            ans[i] = trie.getPrefixScore(words[i]);
        }
        return ans;
    }

    class Trie{
        Trie[] child;
        int count;

        public Trie(){
            child = new Trie[26]; // for alphabates from a to z
            this.count = 0;
        }

        public void insert(String word){
            Trie node = this; // refers to root
            for(char c : word.toCharArray()){
                int ind = c - 'a'; // get corresponding index
                // if nothing is present in that index then insert a new trie there
                if(node.child[ind] == null){
                    node.child[ind] = new Trie();
                }
                // move the node downward and increment the count
                node = node.child[ind];
                node.count++;
            }
        }
        public int getPrefixScore(String word){
            Trie node = this;
            int sum = 0;
            for(char c : word.toCharArray()){
                int ind = c - 'a';
                if(node.child[ind] != null){
                    node = node.child[ind];
                    sum += node.count;
                }
            }
            return sum;
        }
    }
}
