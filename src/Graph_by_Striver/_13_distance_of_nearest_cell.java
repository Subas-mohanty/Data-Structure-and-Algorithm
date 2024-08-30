package Graph_by_Striver;

import java.util.LinkedList;
import java.util.Queue;
//https://bit.ly/3Cc8jlW
public class _13_distance_of_nearest_cell {

    // Intuition for the problem
    // first of all we visit all 1's and put them in the queue with distance = 0
    // do bfs to visit all neighbouring 0's level by level
    // at each step, make steps = steps + 1, because form all 1's we will visit to 0's and we will find the distance using the steps
    // means all the 0's which will be present at level 1 from 1 they will have a distance of 1, and 0's that will be reached in steps 2, they will have a distance of 2 and so on
    // why this is happening, because we are doing bfs and at each bfs call we can reach all 0's which are present at same distance from 1


    // TC : O(n*m*4)
    // SC : O(n*m) for the answer matrix and the visited matrix
    public static int[][] nearest(int [][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;
        int [][] vis = new int[n][m];
        int [][] dist = new int[n][m];
        Queue<Pair> q = new LinkedList<>();

        // visiting all node and if the node is 1 that means we can perform bfs on this, so adding it to the queue
        for(int i = 0; i < n; i++){
            for (int j = 0; j < m; j++) {
               if(matrix[i][j] == 1){
                   // this third thing is the distance from the current cell to the nearest cell, for 1, the distance is 0, because it itself is the nearest so adding the distance 0 here
                   q.offer(new Pair(i, j, 0));
                   vis[i][j] = 1;
               }
               // marking as 0, because it is a 2d array
               else vis[i][j] = 0;
            }
        }

        int [] delRow = {-1, 0, 1, 0};
        int [] delCol = {0, 1, 0, -1};

        // n*m
        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            int steps = q.peek().third;
            q.poll();
            dist[row][col] = steps;

            for(int i = 0; i < 4; i++){
                int newRow = row + delRow[i];
                int newCol = col + delCol[i];

                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && vis[newRow][newCol] ==0){
                    vis[newRow][newCol] = 1;
                    q.offer(new Pair(newRow, newCol, steps+1));
                }
            }
        }
        return dist;
    }



    static class Pair{
        int first;
        int second;
        int third;
        public Pair(int first, int second, int third){
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }
}
