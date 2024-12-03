package Leetcode.Math;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/gray-code/

public class _89_gray_code {
    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            System.out.println(grayCode(i));
        }
    }
    public static List<Integer> grayCode(int n) {
        // gray code is a sequential series like fibonnaci and other
        // nth term in the series -> f(n) = n ^ (n >> 1),
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < (int)Math.pow(2, n); i++){
            list.add(i ^ (i >> 1));
        }
        return list;
    }
}
