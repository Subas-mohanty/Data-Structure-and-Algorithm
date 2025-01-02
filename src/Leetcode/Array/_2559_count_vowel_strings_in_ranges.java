package Leetcode.Array;
//https://leetcode.com/problems/count-vowel-strings-in-ranges/description/?envType=daily-question&envId=2025-01-02

import java.util.Arrays;

public class _2559_count_vowel_strings_in_ranges {

    public static void main(String[] args) {
        String [] s = {"aba","bcb","ece","aa","e"};
        int [][] queries = {{0,2}, {1,4}, {1,1}};
        System.out.println(Arrays.toString(vowelStrings2(s, queries)));
    }

    // TC : O(m + n * log m) --> to process each query it takes O(log m) time and to construct it , it takes O(m) --> it visits each index only once
    // SC : O(m) --> for the segment tree, as it stores all nodes
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = queries.length;
        int [] ans = new int[n];
        SegmentTree tree = new SegmentTree(words);
        int ind = 0;
        for(int [] a : queries){
            ans[ind++] = tree.query(a[0], a[1]);
        }
        return ans;
    }

    static class SegmentTree{
        String [] arr;
        public SegmentTree(String [] arr){
            this.arr = arr;
            this.constructTree(arr);
        }
        Node root;
        public void constructTree(String [] arr){
            this.root = constructTree(0, arr.length -1);
        }
        private Node constructTree(int start, int end){
            if(start == end){
                Node leaf = new Node(start, end);
                leaf.value = 0;
                if(isVowel(arr[start])) leaf.value = 1;
                return leaf;
            }
            int mid = (start + end)/2;
            Node node = new Node(start, end);
            node.left = constructTree(start, mid);
            node.right = constructTree(mid + 1, end);
            node.value = node.left.value + node.right.value;
            return node;
        }
        public int query(int start, int end){
            return this.query(this.root, start, end);
        }
        private int query(Node node, int start, int end){
            // completely inside
            if(start <= node.startInterval && end >= node.endInterval){
                return node.value;
            }
            else if(node.startInterval > end || node.endInterval < start){
                return 0;
            }
            else{
                int left = query(node.left, start, end);
                int right = query(node.right, start, end);
                return left + right;
            }
        }
        private boolean isVowel(String word){
            char first = word.charAt(0);
            char last = word.charAt(word.length() - 1);

            if(first == 'a' || first == 'e' || first == 'i' || first == 'o' || first == 'u'){
                if(last == 'a' || last == 'e' || last == 'i' || last == 'o' || last == 'u') return true;
            }
            return false;
        }
        static class Node{
            int startInterval;
            int endInterval;
            int value;
            Node left;
            Node right;

            public Node(int start, int end){
                this.startInterval = start;
                this.endInterval = end;
            }
        }
    }

    // TC : O(n + q)
    // SC : O(n)
    // create a prefix sum array and store the validVowel string found till that index, take the cumulative sum and then for each query we can find the answer in O(1) time
    public static int[] vowelStrings2(String[] words, int[][] queries) {
        int n = queries.length;
        int [] ans = new int[n];
        int [] prefix = new int[words.length];
        int sum = 0;
        for(int i = 0; i < words.length; i++){
            if(isVowel(words[i])) sum++;
            prefix[i] = sum;
        }
        for(int i = 0; i < n; i++){
            int start = queries[i][0];
            int end = queries[i][1];
            if(start <= 0) ans[i] = prefix[end];
            else ans[i] = prefix[end] - prefix[start-1];
        }
        return ans;
    }
    static boolean isVowel(String word){
        char first = word.charAt(0);
        char last = word.charAt(word.length() - 1);

        if(first == 'a' || first == 'e' || first == 'i' || first == 'o' || first == 'u'){
            if(last == 'a' || last == 'e' || last == 'i' || last == 'o' || last == 'u') return true;
        }
        return false;
    }
}

