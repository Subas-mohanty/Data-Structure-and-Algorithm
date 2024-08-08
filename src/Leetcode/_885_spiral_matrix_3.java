package Leetcode;

// https://leetcode.com/problems/spiral-matrix-iii/description/?envType=daily-question&envId=2024-08-08
// https://www.youtube.com/watch?v=f5m5JdTsL3Y


public class _885_spiral_matrix_3 {
  public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int [][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // for going L R D U, we are just storing them like this for easy access
        int n = rows * cols;
        int [][] res = new int[n][2]; // the result array will contain all grid elements's cordinates so the size will be row * col
        // first element in the result grid is the starting point
        res[0][0] = rStart;
        res[0][1] = cStart;
        int count = 1;
        int steps = 1;
        int ind = 0;
        // when count will be equal to n, which means our resultant array has length of n, this means we traversed the entire grid, now we can return the array 
        while(count < n){
            for(int i = 0; i < 2; i++){
                // why modulo here, because the ind can go beyond the index of the grid, to keep it inside the range and use the directions array as an rotated array we are doing modulo here
                int dRow = directions[ind % 4][0];
                int dCol = directions[ind % 4][1];
                for(int j = 0; j < steps; j++){
                    // updating rStart and cStart, going left, down, right, up
                    rStart += dRow;
                    cStart += dCol;
                    if(rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols){
                        res[count][0] = rStart;
                        res[count][1] = cStart;
                        count++;
                    }
                }
                // after every operation we are updating the ind, after going right we will go to down and then left and up
                ind++;
            }
            steps++;
        }
        return res;
    }
}
