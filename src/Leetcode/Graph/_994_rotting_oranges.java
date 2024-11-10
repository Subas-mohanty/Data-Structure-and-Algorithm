package Leetcode.Graph;
import java.util.*;
//https://leetcode.com/problems/rotting-oranges/

public class _994_rotting_oranges {
    // TC : O(n^2)
    // SC : O(n^2)

    // doing bfs from all the cells which has 2 in it(rotten orange)
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m  = grid[0].length;

        Queue<int [] > q = new LinkedList<>();

        int ones = 0;
        int [][] vis = grid;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(vis[i][j] == 2) q.offer(new int[]{i, j});
                if(vis[i][j] == 1) ones++;
            }
        }

        // if the grid has only 0's in it
        if(ones == 0) return 0;

        int minutes = -1;
        int [][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while(!q.isEmpty()){

            int size = q.size();
            for (int i = 0; i < size; i++) {
                int [] removed = q.poll();
                int x = removed[0];
                int y = removed[1];

                // going in all 4 directions
                for(int [] dir : dirs){
                    int X = x + dir[0];
                    int Y = y + dir[1];
                    // out of bound check
                    if(X < n && Y < m && X >= 0 && Y >= 0 && vis[X][Y] == 1){
                        vis[X][Y] = 2;
                        ones--; // we found a one which can turn into 2, so decrease it by 1
                        q.offer(new int[]{X, Y}); // add the new cell to queue again
                    }
                }
            }
            minutes++;
        }
        if(ones != 0) return -1;
        return minutes;
    }
}
