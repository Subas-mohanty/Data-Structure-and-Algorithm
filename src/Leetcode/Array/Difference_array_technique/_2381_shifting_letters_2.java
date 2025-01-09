package Leetcode.Array.Difference_array_technique;

//https://leetcode.com/problems/shifting-letters-ii/description/?envType=daily-question&envId=2025-01-05

public class _2381_shifting_letters_2 {
    // TC : O(n + m)
    // SC : O(n)
    // difference array is a technique, where we perform some task inside a range
    // first we find the number of times we need to perform the task at each index
    // but how do we do that in O(n) time ?
    // lets say we have an array and we want to add 5 at each index from 2-4
    // what we can do is, we can put 5 at index 2 and -5 at index 4 + 1, and take the cumulative sum and again if we want to add -2 at index 3-5, we can add -2 at index 3 and 2 at index 5 + 1(6)
    // watch the youtube lecture to understand it
    // https://www.youtube.com/watch?v=ZHNVmtm08WY
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int [] arr = new int[n];

        for(int [] a : shifts){
            int start = a[0];
            int end = a[1];
            int dir = a[2];
            // if direction is backward add -1 from start to end, so according to the above formula, we can add -1 at start and 1 at index end + 1
            if(dir == 0) {
                arr[start] += -1;
                if(end + 1 < n) arr[end + 1] += 1;
            }
            else {
                arr[start] += 1;
                if(end + 1 < n) arr[end + 1] += -1;
            }
        }
        // now find the cumulative sum
        for(int i = 1; i < n; i++){
            arr[i] += arr[i-1];
        }
        // build the ans string
        StringBuilder sb = new StringBuilder(s);
        for(int i = 0; i < n; i++){
            sb.setCharAt(i, findChar(i, arr, s.charAt(i)));
        }
        return sb.toString();
    }
    // this function finds the new char after counting how many times it will be forward or backward
    char findChar(int ind, int [] arr, char ch){
        int diff = arr[ind];
        if(diff == 0) return ch;
        if(diff < 0) return getbackward(ch, diff * -1);
        else return replace(ch, diff);
    }
    char replace(char curr, int freq){
        char ch = (char) ( 'a' + (curr - 'a' + freq) % 26 );
        return ch;
    }
    char getbackward(char curr, int freq) {
        int adjustedFreq = ((curr - 'a' - freq) % 26 + 26) % 26;
        char ch = (char) ('a' + adjustedFreq);
        return ch;
    }
}
