package Graph_by_Striver;

// https://leetcode.com/problems/shortest-path-in-binary-matrix/

import java.util.LinkedList;
import java.util.Queue;

public class _1091_shortest_path_in_matrix {

    // TC : O(m*n)

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        // If the start or end is blocked, return -1
        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;

        // if the grid has only one element and it is 0, then return 1
        if(n == 1 && grid[0][0] == 0) return 1;

        Queue<int[]> q = new LinkedList<>();

        // storing row, col, distance in the queue
        q.offer(new int[]{0,0,1});
        grid[0][0] = 1; // marking visited

        while(!q.isEmpty()){
            int [] removed = q.poll();
            int row = removed[0], col = removed[1], dist = removed[2];

            for(int i = -1; i <=1; i++){
                for(int j = -1; j <= 1; j++){
                    int newRow = row + i;
                    int newCol = col + j;

                    if(newRow == n-1 && newCol == n-1) return dist+1;

                    // if in bound add to the queue
                    if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && grid[newRow][newCol] == 0){
                        q.offer(new int[]{newRow, newCol, 1 + dist});
                        grid[newRow][newCol] = 1; // marking as visited
                    }
                }
            }
        }
        return -1;
    }



    // modified version for GFG

    public int shortestPath(int[][] grid,  int[] src, int[] des) {
        int n = grid.length;
        int m = grid[0].length;
        // If the start or end is blocked, return -1
        if (grid[src[0]][src[1]] == 0 || grid[des[0]][des[1]] == 0) return -1;

        // Special case: If the source is the destination
        if (src[0] == des[0] && src[1] == des[1]) return 0;


        Queue<int[]> q = new LinkedList<>();

        // storing row, col, distance in the queue
        q.offer(new int[]{src[0], src[1], 1});
        grid[src[0]][src[1]] = 0; // marking visited

        int [][] distance= {
                {-1,0}, {0,1}, {1,0}, {0,-1}
        };
        while(!q.isEmpty()){
            int [] removed = q.poll();
            int row = removed[0], col = removed[1], dist = removed[2];

            for (int i = 0; i < 4; i++) {
                int newRow = row + distance[i][0];
                int newCol = col + distance[i][1];

                if(newRow == des[0] && newCol == des[1]) return dist;

                // if in bound add to the queue
                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == 1){
                    q.offer(new int[]{newRow, newCol, 1 + dist});
                    grid[newRow][newCol] = 0; // marking as visited
                }
            }
        }
        // no path found
        return -1;
    }
}
