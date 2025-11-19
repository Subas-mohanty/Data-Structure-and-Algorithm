import java.util.*;
class Solution {
    void main(){
        List<String> list = Arrays.asList("ninja" , "night" , "nil");
        System.out.println(completeString(list));
    }
    public String completeString(List<String> nums) {
        Trie trie = new Trie();
        for(String s : nums) trie.insert(s);

        String result = "";
        for(String s : nums){
            if(trie.checkIfExist(s)){
                if(s.length() > result.length()) result = s;
                else if(s.length() == result.length() && s.compareTo(result) < 0) result = s;
            }
        }
        return result.equals("") ? "None" : result;
    }
}
class Trie{
    Node root;

    public Trie(){
        root = new Node();
    }

    void insert(String s){
        Node node = root;
        for(char ch : s.toCharArray()){
            if(node.child[ch - 'a'] == null) node.child[ch - 'a'] = new Node();
            node = node.child[ch - 'a'];
        }
        node.eow = true;
    }

    boolean checkIfExist(String s){
        Node node = root;
        boolean flag = true;
        for(char ch : s.toCharArray()){
            if(node.child[ch - 'a'] != null){
                flag = flag & node.child[ch - 'a'].eow;
                node = node.child[ch - 'a'];
            }
            else return false;
        }
        return flag;
    }
    class Node{
        Node [] child = new Node[26];
        boolean eow = false;
    }
}