package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _11_majorityElement {
    public static void main(String[] args) {
     }
    public int majority(int [] arr){
        int count=0;
        int el=arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(count==0){
                count=1;
                el=arr[i];
            }
            else if(arr[i]==el){
                count++;
            }
            else{
                count--;
            }
        }
        return -1;
    }
}
