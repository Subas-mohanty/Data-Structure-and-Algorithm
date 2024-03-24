package Dynamic_Programming_Striver;

import java.util.Arrays;
// didn't understand a single thing about the problem
public class _52_burst_balloons {
    public static void main(String[] args) {
        int [] arr = {3,1,5,8};
        int [] newArr = new int[arr.length +2];
        newArr[0] = 1;
        newArr[newArr.length-1] = 1;
        for(int i = 0; i< arr.length; i++){
            newArr[i+1] = arr[i];
        }
        System.out.println(balloons(newArr, 1, arr.length));
    }
    public static int balloons(int [] arr, int i, int j){
        if(i > j) return 0;
        int max = Integer.MIN_VALUE;
        for(int k = i; k <= j; k++){
            int points = arr[i-1] * arr[k] * arr[j+1] + balloons(arr, i, k-1) + balloons(arr, k+1, j);
            max = Math.max(max, points);
        }
        return max;
    }
}
