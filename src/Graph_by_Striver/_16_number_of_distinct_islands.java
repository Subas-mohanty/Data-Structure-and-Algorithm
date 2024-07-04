package Graph_by_Striver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
//https://bit.ly/3AsA08W
public class _16_number_of_distinct_islands {
    // TC : O(n * m * log(set.length) + (n * m * 4)) --> for two nested loop its n*m and set addition is log n*m and the four dfs is 4 * n* m
    // SC : O(n*m) for the set and the visit array
    int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int [][] visit = new int[n][m];
        // with the help of the set we are keeping track of the shape of the island with the help of the coordinates, for example for every coordinate we are subtracting the coordinate value from the base coordinate and storing them in a set to get all the unique values
        Set<List<String>> set = new HashSet<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(visit[i][j] == 0 && grid[i][j] == 1){
                    List<String> list = new ArrayList<>();
                    // n * m * 4
                    dfs(grid, visit, i, j, list, i, j);
                    set.add(list);
                }
            }
        }
        return set.size();
    }
    void dfs(int [][] grid, int [][] visit, int i, int j, List<String> list , int first, int second){
        int n = grid.length;
        int m = grid[0].length;

        if(i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == 0 || visit[i][j] == 1) return;

        visit[i][j] = 1;
        list.add(toString(i-first, j-second));

        dfs(grid, visit, i-1, j, list, first, second); // up
        dfs(grid, visit, i+1, j, list, first, second); // down
        dfs(grid, visit, i, j-1, list, first, second); // left
        dfs(grid, visit, i, j+1, list, first, second); // right
    }
    String toString(int a , int b){
        return Integer.toString(a) + " " + Integer.toString(b);
    }
}
