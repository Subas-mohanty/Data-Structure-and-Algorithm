package Leetcode.Array;

//https://leetcode.com/problems/maximum-matrix-sum/?envType=daily-question&envId=2024-11-24

// the question is little tricky in wording

// solution :
// Find the absolute sum of all the numbers in the matrix
// Find the absolute value of the smallest number in the matrix
// Count of negative numbers in the matrix
// If count of negatives is even, then all elements can be made +ve by performing the operation, so just return sum
// but how all the elements can be turned to positive ? what if they are not adjacent then.... still we can make them positive, because from any negative number we can go to its adjacent and mark make the number positive by changing its sign with the adjacent element and we can do it many times so we can make them all positive
// If count of negatives is odd, then we can make the smallest number in the matrix as -ve and then return sum

// example
// -25 3 1
//  2  6 7
//  28 2 9

// now the question is how we can make 25 as positive and 1 as negative
// first take -25 and 3, multiplying -1 with each will give us 25 and -3, now take -3 and 1, and do the same operation it will be turned to 3 and -1, and our job is done

public class _1975_maximum_matrix_sum {
    // TC : O(m * n)
    // SC : O(1)
    public long maxMatrixSum(int[][] matrix) {
        long min = (int)1e9;
        long sum = 0;
        int negative = 0;
        for(int [] a : matrix){
            for(int b : a){
                sum += Math.abs(b);
                min = Math.min(min, Math.abs(b));
                if(b < 0) negative++;
            }
        }
        if(negative % 2 == 0) return sum;
        return sum - min - min;
    }
}
