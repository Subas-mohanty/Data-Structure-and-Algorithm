package Leetcode.Trie;

class TrieWithMultiWordPresence{
    void main(){
        Trie trie = new Trie();
        trie.insert("subas");
        trie.insert("subas");
        trie.insert("subas");
        trie.insert("subas");
        System.out.println(trie.countWordsEqualTo("subas"));
        System.out.println(trie.countWordsStartingWith("ratan"));
        System.out.println(trie.countWordsStartingWith("sub"));
        System.out.println();
        trie.insert("subham");
        System.out.println(trie.countWordsEqualTo("subas"));
        System.out.println(trie.countWordsStartingWith("ratan"));
        System.out.println(trie.countWordsStartingWith("sub"));
        System.out.println();

        trie.erase("subas");
        System.out.println(trie.countWordsEqualTo("subas"));
        System.out.println(trie.countWordsStartingWith("ratan"));
        System.out.println(trie.countWordsStartingWith("sub"));
    }
}


// how we are storing count of words ?
// for each node we have a count property, which stores how many words contains this character
// if that node is eow (end of word) this means count no. of words ends at that node, so there are count no. of words present
class Trie {
    static class Node{
        Node[] child = new Node[26];
        boolean eow = false;
        int count = 0; // initially each word's count is 0
    }
    Node root;
    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        for(char ch : word.toCharArray()){
            if(node.child[ch - 'a'] == null) node.child[ch - 'a'] = new Node();
            node.child[ch - 'a'].count++;
            node = node.child[ch - 'a'];
        }
        node.eow = true;
    }

    public int countWordsEqualTo(String word) {
        Node node = root;
        for(char ch : word.toCharArray()){
            if(node.child[ch - 'a'] != null) {
                node = node.child[ch - 'a'];
            }
        }
        if(!node.eow) return 0;
        return node.count;
    }

    public int countWordsStartingWith(String prefix) {
        Node node = root;
        for(char ch : prefix.toCharArray()){
            if(node.child[ch - 'a'] != null) {
                node = node.child[ch - 'a'];
            }
            else break;
        }
        return node.count;
    }

    public void erase(String word) {
        int wordCount = countWordsEqualTo(word);
        if(wordCount == 0) return;
        Node node = root;
        for(char ch : word.toCharArray()){
            node.child[ch - 'a'].count--;
            node = node.child[ch - 'a'];
        }
        if(wordCount == 1) node.eow = false;
    }
}