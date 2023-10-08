package Leetcode;

import java.util.Arrays;
import java.util.Collections;

public class _19_thirdMax {
    public static void main(String[] args) {
        int [] arr = {1,2};
        System.out.println(thirdMax(arr));
    }
    static public int thirdMax(int[] nums) {
        Integer[] arr = Arrays.stream( nums ).boxed().toArray( Integer[]::new );
        Arrays.sort(arr, Collections.reverseOrder());
        int ans=arr[0];
        int count=1;

        for(int i=0;i<arr.length;i++){
            if(arr[i]!=ans){
                ans=arr[i];
                count++;
            }
            if(count==3){
                return ans;
            }
        }
        return arr[0];
    }
}
