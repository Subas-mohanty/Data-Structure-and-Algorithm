package Lecture_practice_problems._32_Recursion_05;
//https://leetcode.com/problems/subsets/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// taking some elements and removing some elements
public class _03_Subsets {
    public static void main(String[] args) {
        int [] arr={1,2,3};
        List<List<Integer>> ans=subset(arr);
        for(List<Integer> list: ans){
            System.out.print(list);
        }
        System.out.println();

        List<List<Integer>> list = new ArrayList<>();
        helper(arr, list, new ArrayList<>(), 0);
        System.out.println(list);
    }

    public static void helper(int[] nums, List<List<Integer>> list, List<Integer> temp, int ind){
        if(ind == nums.length){
            list.add(new ArrayList(temp));
            return;
        }
        helper(nums, list, temp, ind+1); // not take
        temp.add(nums[ind]); // taking the value
        helper(nums, list, temp, ind+1);
        temp.removeLast(); // backtrack to remove the value
    }
    // TC : O(N*2^N) --> No. of elements * total no. of subsets
    // SC : O(N*2^N) --> size of each list * no of list in the outer/answer array(no. of subsets)
    static List<List<Integer>> subset(int [] arr){
        List<List<Integer>> outer=new ArrayList<>();
        // adding an empty list to the outer list
        outer.add(new ArrayList<>());

        // for every number we are running the inside loop the number of times, the number of elements the outer list has
        for(int num:arr){
            int n=outer.size();
            for (int i = 0; i < n; i++) {
                // copying the previous elements with the constructor and adding the number in each element
                List<Integer> internal=new ArrayList<>(outer.get(i));
                internal.add(num);
                outer.add(internal);
            }
        }
        return outer;
    }
    // when we find a duplicate element, only add it in the newly created subset of previous steps
    // because of above point duplicates needs to be together so sort the array
    static ArrayList<ArrayList<Integer>> subset2(int [] arr){
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());

        int start =0;
        int end =0;

        for(int i =0; i<arr.length; i++){
            start =0;
            int n = outer.size();
            // found a duplicate means the current and the previous element is same
            if(i > 0 && arr[i] == arr[i-1]){
                start= end+1;
            }
            // as the previous if will not going to work for i=0 or for the first element , so this will be the end = 2-1=1, then we will end the next element from the 1st index
            // look what we are doing is , when we found a duplicate element we are not adding it from the start as we were doing before instead we start adding the number from the previous end or after the index till where that element has already been added due to its first occurrence
            end = outer.size() -1;
            for(int j=start; j< n; j++){
                ArrayList<Integer> temp = new ArrayList<>(outer.get(j));

                temp.add(arr[i]);
                outer.add(temp);
            }
        }
        return outer;
    }
}
