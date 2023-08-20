package Assignment._05_arrays._01_easy;

import java.util.Arrays;

public class _02_concatenationOf_array {
    public static void main(String[] args) {
        int [] arr = {2,4,5,9,8};
        int [] ans =new int[10];
        for (int i = 0; i < 5; i++) {
            ans[i]=arr[i];
            ans[i+5]=arr[i];
        }
        System.out.println(Arrays.toString(ans));
    }
}
