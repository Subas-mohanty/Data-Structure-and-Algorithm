package Leetcode.Backtracking;

import java.util.ArrayList;
import java.util.List;
// https://leetcode.com/problems/permutations/description/
public class _46_permutation {
    public static void main(String[] args) {
        int[] arr={1,2,3};
        System.out.println(permute(arr));
    }
    static List<List<Integer>> permute(int[] arr) {
        List<List<Integer>> list=new ArrayList<>();
         return backtrack(list,new ArrayList<>(),arr);
    }

    static private List<List<Integer>> backtrack(List<List<Integer>> list, ArrayList<Integer> tempList, int[] arr) {
        if(tempList.size()==arr.length){
            // we create new arraylist everytime with the tempList value and add it to the answer list
            list.add(new ArrayList<>(tempList));
            return list;
        }
        for (int nums:arr) {

            // if the num is already present in the tempList then skip it
            if(tempList.contains(nums)){
                continue;
            }

            // if the num is not present in the tempList then we add it in tempList
            tempList.add(nums);
            backtrack(list,tempList,arr);

            // backtrack -> after the function call we remove the num from the last and go back
            tempList.remove(tempList.size()-1);
        }
        return list;
    }
}
