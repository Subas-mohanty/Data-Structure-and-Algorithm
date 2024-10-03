package Leetcode.Trie;
//https://leetcode.com/problems/implement-trie-prefix-tree/description/

class _208_implement_Trie {
    Node root;
    public _208_implement_Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node temp = root;
        for (char c : word.toCharArray()) {
            if (temp.child[c - 'a'] == null) {
                temp.child[c - 'a'] = new Node();
            }
            temp = temp.child[c - 'a'];
        }
        temp.eow = true;
    }

    public boolean search(String word) {
        Node temp = root;
        for (char c : word.toCharArray()) {
            int chInd = c - 'a';
            if (temp.child[chInd] == null) return false;
            temp = temp.child[chInd];
        }
        return temp.eow;
    }

    public boolean startsWith(String prefix) {
        Node temp = root;
        for (char c : prefix.toCharArray()) {
            int chInd = c - 'a';
            if (temp.child[chInd] == null) return false;
            temp = temp.child[chInd];
        }
        return true;
    }

    class Node {
        boolean eow = false;
        Node[] child = new Node[26];
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
