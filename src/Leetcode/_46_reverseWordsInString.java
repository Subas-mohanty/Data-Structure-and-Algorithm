package Leetcode;

import java.util.Arrays;
//https://leetcode.com/problems/reverse-words-in-a-string/description/

public class _46_reverseWordsInString {
    public static void main(String[] args){
        String s = "example   good a";
        // String[] arr = s.trim().split(" "); // we can't do this as there might a test case where there will be multiple whitespaces between the words, in that case it will fail
        String [] arr = s.trim().split("\\s+");
        System.out.println(Arrays.toString(arr));
        System.out.println(reverseWords(s));
    }
    public static String reverseWords(String s) {
        // String[] arr = s.trim().split(" "); // we can't do this as there might a test case where there will be multiple whitespaces between the words, in that case it will fail
        String [] arr = s.trim().split("\\s+");
        // reverse the array
        reverse(arr);
        return String.join(" ", arr);
    }
    public static void reverse(String [] arr){
        int length = arr.length;
        for(int i =0; i< length/2; i++){
            String temp = arr[i];
            arr[i] = arr[length - 1 - i];
            arr[length - i - 1] = temp;
        }
    }
}
