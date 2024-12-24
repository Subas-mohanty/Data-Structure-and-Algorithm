package Leetcode.BinarySearch;

// https://leetcode.com/problems/magnetic-force-between-two-balls/description/

import java.util.Arrays;

public class _1552_max_magnetic_force {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,7};
        int m = 3;
        System.out.println(maxDistance(arr, m));
    }
    public static int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int s = position[0];
        int e = position[position.length - 1];
        int n = 0;
        int mid = 0;
        while(true){
            if((int)Math.pow(n-1, 2) + 1 < m && (int)Math.pow(n,2)+1 >= m){
                while(n > 0){
                    mid = s+(e-s)/2;
                    n--;
                    e = mid;
                }
                return mid - s;
            }
            n++;
        }
    }
}
