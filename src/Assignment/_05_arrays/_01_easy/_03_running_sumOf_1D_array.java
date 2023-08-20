package Assignment._05_arrays._01_easy;

import java.util.Arrays;

public class _03_running_sumOf_1D_array {
    public static void main(String[] args) {
        int [] arr={3,5,4,2,6,7};
        int sum=0;
        int [] ans=new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i]=sum+arr[i];
            sum+=arr[i];
        }
        System.out.println(Arrays.toString(ans));
    }
}
