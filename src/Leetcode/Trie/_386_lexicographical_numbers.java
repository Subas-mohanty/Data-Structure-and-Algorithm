package Leetcode.Trie;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/lexicographical-numbers/description/?envType=daily-question&envId=2024-09-21


public class _386_lexicographical_numbers {

    // TC : O(n)
    // SC : O(n) --> for recursion stack space

    List<Integer> list = new ArrayList<>();
    public List<Integer> lexicalOrder(int n) {
        // go form digit 1 to 9
        for(int i = 1; i <= 9; i++) dfs(i,n);
        return list;
    }
    void dfs(int num, int n){

        // if num is greater than n than no need to do anything simply return
        if(num > n) return;

        // add the num to the result
        list.add(num);
        num *= 10;
        // check for next level, for ex, if num is 1 then now check for 10, 11, 12, 13......
        // in the next level num will again be like 100, 101, 102......
        // it is a trie
        //      1       2       3       4       5       6       7       8       9
        //    10 11   20 21   30 31
        // 100 101     210 211
        // and we are going preorder, node -> left -> right, so addding like 1, 10, 100, 101 and so on
        for(int i = 0; i <= 9; i++) dfs(num+i, n);
    }
}
