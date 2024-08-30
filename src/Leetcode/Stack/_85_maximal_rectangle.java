package Leetcode.Stack;


import java.util.Arrays;
import java.util.Stack;

//https://leetcode.com/problems/maximal-rectangle/

public class _85_maximal_rectangle {
    public static void main(String[] args) {
//        char[][] matrix = {
//                {'1','0','1','0','0'},
//                {'1','0','1','1','1'},
//                {'1','1','1','1','1'},
//                {'1','0','0','1','0'},
//        };
        char [][] matrix = {
                {'0', '1'},
                {'1','0'}
        };
        System.out.println(maximalRectangle(matrix));

    }

    // TC : O(n*m) --> the largest histogram function takes O(m) and we are calling that function for n (no. of rows) times
    public static int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int [] arr = new int[m];
        int max = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == '1')  arr[j] = arr[j] + matrix[i][j] - '0';
                else arr[j] = 0;
            }
            max = Math.max(max, largestRectangleArea(arr));
        }
        return max;
    }


    // below is the code for leetcode 84 largest rectangle from histogram
    public static int largestRectangleArea(int[] heights) {
        int [] pse = findPSE(heights); // previous smaller
        int [] nse = findNSE(heights); // next smaller
        int max = 0;

        // for each index find the max rectangle area we can build
        for(int i = 0; i < heights.length; i++){
            int width = nse[i] - pse[i] - 1; // width of the rectangle which we can make at that index
            int area = width * heights[i];
            max = Math.max(area, max);
        }
        return max;
    }

    // find previous smaller element
    public static int [] findPSE(int [] arr){
        Stack<Integer> stack = new Stack<>();
        int [] ans = new int[arr.length];

        for(int i = 0; i < arr.length; i++){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) stack.pop();
            if(stack.isEmpty()) ans[i] = -1;
            else ans[i] = stack.peek();
            stack.push(i);
        }
        return ans;
    }

    // find next smaller element
    public static int [] findNSE(int [] arr){
        Stack<Integer> stack = new Stack<>();
        int [] ans = new int[arr.length];

        for(int i = arr.length - 1; i >= 0; i--){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) stack.pop();
            if(stack.isEmpty()) ans[i] = arr.length;
            else ans[i] = stack.peek();
            stack.push(i);
        }
        return ans;
    }
}
