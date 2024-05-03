package Leetcode;

import java.util.Arrays;
//https://shorturl.at/hpR16
public class _85_findMedian_matrix {

    public static void main(String[] args) {
        int [][] matrix = {
                {1, 5, 7, 9, 11 },
                {2, 3, 4, 8, 9},
                {4, 11, 14, 19, 20},
                {6, 10, 22, 99, 100},
                {7, 15, 17, 24, 28 }
        };
        int m = matrix.length;
        int n = matrix[0].length;
        System.out.println(findMedian(matrix, m, n));
        System.out.println(findMedian2(matrix, m, n));
        System.out.println(findMedian3(matrix, m, n));
    }

    public static int findMedian3(int [][] matrix, int m, int n) {
        int low = Integer.MAX_VALUE; int high = Integer.MIN_VALUE;
        int ans = 0;
        for (int i = 0; i < m ; i++) {
           low = Math.min(low, matrix[i][0]);
           high = Math.max(high, matrix[i][n-1]);
        }

        // binary search between low and high
        while(low <= high){
            int mid = low+(high-low)/2;
            int noLessThanMid = checkNumLessMid(matrix, mid);
            if(noLessThanMid <= (n*m)/2) low = mid+1;
            else{
                ans = mid;
                high = mid-1;
            }
        }
        return ans;
    }

    // for a median the number of elements on its left and right will be n/2;
    // and if we add the median then its n/2 + 1
    // so if for any mid the no of elements less than the mid is less than or equal to the above number than we have to search in the right half
    // now to check how many numbers are less than equal to mid, we can do binary search on each row to find the upperbound which means the index of upperbound is same as the number of elements less than or equal to that element is present in the array
    private static int checkNumLessMid(int[][] matrix, int mid) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            count+= upperBound(matrix[i], mid);
        }
        return count;
    }

    public static int upperBound(int[] arr, int target) {
        int n = arr.length;

        if (target > arr[n - 1]) return n;
        if (target < arr[0]) return 0;

        int ub = n;
        int start = 0;
        int end = n-1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) start = mid + 1;
            else if (arr[mid] > target) {
                ub = mid;
                end = mid - 1;
            } else start = mid + 1;
        }
        return ub;
    }

    // SC : O(m*n)
    // TC : O(m*n + m*n(log m*n))
    public static int findMedian2(int [][] matrix, int m, int n) {
        int [] arr = new int[m*n];
        int k = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
               arr[k] = matrix[i][j];
               k++;
            }
        }
        Arrays.sort(arr);
        // the number of elements in the matrix is odd, given m and n are odd
        return arr[k/2];
    }

    public static int findMedian(int [][] matrix, int m, int n) {
        int[] ans = matrix[0];
        for (int i = 1; i < matrix.length; i++) {
            ans = merge(matrix[i], ans);
        }
        int length = ans.length;
        System.out.println(Arrays.toString(ans));
        if (length % 2 == 1) return ans[length / 2];
        return (ans[length / 2] + ans[length / 2 + 1]) / 2;
    }

    // merging two arrays
    public static int[] merge(int[] first, int[] second) {
        int[] ans = new int[first.length + second.length];
        int i = 0, j = 0, k = 0;

        while (i < first.length && j < second.length) {
            if (first[i] < second[j]) {
                ans[k] = first[i];
                k++;
                i++;
            } else {
                ans[k] = second[j];
                j++;
                k++;
            }
        }
        while (i < first.length) {
            ans[k] = first[i];
            i++;
            k++;
        }
        while (j < second.length) {
            ans[k] = second[j];
            j++;
            k++;
        }
        return ans;

    }}
