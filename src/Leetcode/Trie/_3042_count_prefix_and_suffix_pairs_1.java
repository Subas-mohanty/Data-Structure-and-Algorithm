package Leetcode.Trie;

//https://leetcode.com/problems/count-prefix-and-suffix-pairs-i/description/?envType=daily-question&envId=2025-01-08

public class _3042_count_prefix_and_suffix_pairs_1 {
    // TC : O(n * (l + l + n(l + l))
    // --> O(n * (n * l)) --> O(n^2 * l)
    // SC : O(n * l)
    public long countPrefixSuffixPairs(String[] words) {
        int n = words.length;
        int count = 0;
        for(int i = 0; i < n; i++){ // O(n)
            Trie prefix = new Trie();
            Trie suffix = new Trie();
            prefix.insert(words[i]); // O(l)
            suffix.insert(new StringBuilder(words[i]).reverse().toString()); // O(l)

            for (int j = 0; j < i; j++) { // O(n)
                if(prefix.startsWith(words[j]) && suffix.startsWith(new StringBuilder(words[j]).reverse().toString())) count++; // O(l + l)
            }
        }
        return count;
    }

    public class Trie {
        Node root;

        public Trie(){
            root = new Node();
        }

        // O(l)
        public void insert(String word){
            Node temp = root;
            for(char ch : word.toCharArray()){
                if(temp.child[ch - 'a'] == null) temp.child[ch - 'a'] = new Node();
                temp = temp.child[ch - 'a'];
            }
            temp.eow = true;
        }

        // O(l)
        public boolean startsWith(String start){
            Node temp = root;
            for(char ch : start.toCharArray()){
                if(temp.child[ch - 'a'] == null) return false;
                temp = temp.child[ch - 'a'];
            }
            return true;
        }

        class Node{
            boolean eow = false;
            Node[] child = new Node[26];
        }
    }

}
