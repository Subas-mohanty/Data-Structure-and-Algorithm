package Leetcode;

import java.util.ArrayList;
//https://shorturl.at/YMwSK
public class _91_subsetSum {
    static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
        ArrayList<Integer> res = new ArrayList<>();
        helper(res, arr, 0, 0);
        return res;
    }
    public static void helper(ArrayList<Integer> list , ArrayList<Integer> arr, int i, int sum){
        if(i == arr.size()){
            list.add(sum);
            return;
        }
        // we are taking the take and not take approach, and when we took an element we are incrementing the sum and while leaving the element we are leaving the sum as it is
        helper(list, arr, i+1, sum + arr.get(i));
        helper(list, arr, i+1, sum);
    }
}
