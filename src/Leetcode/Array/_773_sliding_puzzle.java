package Leetcode.Array;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

//https://leetcode.com/problems/sliding-puzzle/?envType=daily-question&envId=2024-11-25
//https://www.youtube.com/watch?v=d_DIBUophu8

public class _773_sliding_puzzle {
    String s = "123450";
    public int slidingPuzzle(int[][] board) {
        return helper(board);
    }

    // TC : O(6!)
    // SC : O(6!) --> for the visited array
    int helper(int [][] board){
        String str = getString(board);
        Queue<String> q = new LinkedList<>();
        Set<String> vis = new HashSet<>();

        q.offer(str);
        vis.add(str);

        int moves = 0;

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){
                String curr = q.poll();
                if(curr.equals(s)) return moves;

                // index after converting to string
                int zeroIndex = curr.indexOf("0");

                int row = zeroIndex / 3;
                int col = zeroIndex % 3;

                // going in all 4 directions
                int [][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
                for(int [] dir : directions){
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    if(newRow >= 0 && newRow < 2 && newCol >= 0 && newCol < 3){
                        // index of 0 in string after swapping
                        int newZeroIndex = newRow * 3 + newCol;
                        String next = swap(zeroIndex, newZeroIndex, curr);
                        if(!vis.contains(next)){
                            vis.add(next);
                            q.offer(next);
                        }
                    }
                }
            }
            moves++;
        }

        return -1;
    }
    // swaps two index of the string and returns the new string after swapping
    String swap(int s, int e, String str){
        char [] ch = str.toCharArray();
        char t = ch[s];
        ch[s] = ch[e];
        ch[e] = t;
        return new String(ch);
    }
    // convert the 2d array to string
    String getString(int [][] board){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 3; j++){
                sb.append(board[i][j]);
            }
        }
        return sb.toString();
    }
}
