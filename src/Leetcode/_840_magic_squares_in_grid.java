package Leetcode;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/magic-squares-in-grid/submissions/1350223917/?envType=daily-question&envId=2024-08-09
public class _840_magic_squares_in_grid {
    // this is the brute force by the way
    // TC : O(n*m)
    // SC : O(1)
    public int numMagicSquaresInside(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if((n*m) < 9) return 0;
        int ans = 0;

        // checking for all 3*3 grids to see if they are valid or not
        for (int i = 0; i < n-2; i++) {
            for (int j = 0; j < m-2; j++) {
                ans += helper(grid, i, i+2, j, j+2);
            } 
        }
        return ans;
    }
    public int helper(int [][] grid, int rowStart, int rowEnd, int colStart, int colEnd){
        int n = grid.length;
        int m = grid[0].length;
        int range = (rowEnd - rowStart + 1) * (colEnd - colStart + 1);
        if(range != 9) return 0; // if not 3*3 return 0, means no valid grid found
        if(checkGrid(grid, rowStart, rowEnd, colStart, colEnd)) return 1; // if a valid grid found return 1
        return 0;
    }

    public boolean checkGrid(int [][] grid, int rowStart, int rowEnd, int colStart, int colEnd){
        // checking for the unique element, whenever we encounter a value we remove that from the set, so at the end the set should be empty if there are all unique elements
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < 10; i++) {
           set.add(i);
        }
        // for row sum and check if they are equal to 15 or not, because in a valid greed said in the question, every row sum should be equal to 15
        for (int i = rowStart; i <= rowEnd; i++) {
            int sum = 0;
            for (int j = colStart; j <= colEnd ; j++) {
               sum += grid[i][j];
               set.remove(grid[i][j]);
            }
            if(sum != 15) return false;
        }
        if(!set.isEmpty()) return false;

        // for col sum
        for (int i = colStart; i <= colEnd; i++) {
            int sum = 0;
            for (int j = rowStart; j <= rowEnd ; j++) {
                sum += grid[j][i];
            }
            if(sum != 15) return false;
        }
        
        // for diagonal sum
        int sumDiag = grid[rowStart][colStart] + grid[rowStart+1][colStart+1] + grid[rowStart+2][colStart+2];
        if(sumDiag != 15) return false;
        
        sumDiag = grid[rowEnd][colEnd] + grid[rowEnd-1][colEnd-1] + grid[rowEnd-2][colEnd-2];
        if(sumDiag != 15) return false;
        return true;
    }
}
