package Leetcode.Backtracking;
import java.util.Arrays;

public class _46_count_permutations {
    void main(){
        int [] arr = {1,2,3};
        System.out.println(permutations(arr));
    }

    int permutations(int [] arr){
        int n = arr.length;
        return helper(0, arr, n);
    }
    int helper(int index, int [] arr, int n){
        if(index == n){
            System.out.println(Arrays.toString(arr));
            return 1;
        }

        int count = 0;
        for(int i = index; i < n; i++){
            swap(i, index, arr); // why swapping ?
            // for array [1,2,3]
            // we want to try each number in position 1:
            // Put 1 at position 1 → explore remaining positions
            // Put 2 at position 1 → explore remaining positions
            // Put 3 at position 1 → explore remaining positions
            // we can do this by swapping

            count += helper(index + 1, arr, n);
            swap(i, index, arr);
        }
        return count;
    }

    void swap(int s, int e, int [] arr){
        int temp = arr[s];
        arr[s] = arr[e];
        arr[e] = temp;
    }
}
