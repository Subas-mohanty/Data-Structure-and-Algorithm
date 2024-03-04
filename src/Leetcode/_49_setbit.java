package Leetcode;

import java.util.Arrays;
//https://bit.ly/3InG2Lo
public class _49_setbit {
    public static void main(String[] args) {
        int num = 25;
        int digit = 3;
        int [] ans = bitManipulation(num, digit);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] bitManipulation(int num, int i){
        int [] arr = new int[3];
        int temp = num;
        int bit = (num >> i-1) &1;

        arr[0] = bit;
        if(bit == 0){
            int mask = 1 << i - 1;
            int ans = num | mask; // answer after setting the bit as 1
            arr[1] = ans;
            arr[2] = num;
        }
        else{
            int mask = ~(1 << i - 1);
            int ans = num & mask; // answer after setting the bit as 0
            arr[1] = num;
            arr[2] = ans;
        }

        return arr;
    }
}
