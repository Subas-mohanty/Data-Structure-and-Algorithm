package Dynamic_Programming_Striver;

import java.util.Arrays;
import java.util.Comparator;

class StringComparator implements Comparator<String>{
    public int compare(String s1, String s2){
        return s1.length() - s2.length(); // if 1 it will sort increasingly
        // if -1 , it will sort decreasingly
        // if 0 will not sort it
    }
}
public class _46_longest_string_chain {
    public static void main(String[] args) {
//        String [] arr = {"hsjsw", "hsjs", "hs", "fduou", "h", "m", "hsj"};
        String [] arr = {"j", "wu"};
        Arrays.sort(arr, new StringComparator());
        System.out.println(Arrays.toString(arr));
//        System.out.println(compare(arr[2], arr[0]));

        System.out.println(lis3(arr));
    }
     public static int lis3(String [] arr){
        int n = arr.length;
        int [] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
//                if(arr[i] > arr[j]) // this code was for longest increasing subsequences, for string we have to check if both string differs by only length 1 and they are differentiated by only one character
               if(compare(arr[i], arr[j])){
                   // the bug was
                   dp[i] = Math.max(dp[i], 1 + dp[j]);
               }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

    // check if two strings are like this -: {ab,abc}, {a,ab}, {bca, bcd} etc
    private static boolean compare(String s, String s1) {
        if(s.length() - s1.length() != 1) return false;
        int i = 0;
        int j = 0;
        // when both character are equal we are moving both i and j else moving only i, and in the end if both are equal to s.length() and s1.length() then we can say they are valid
        while(i < s.length()){
            if(j < s1.length() && s.charAt(i) == s1.charAt(j)){
                i++;
                j++;
            }
            else i++;

        }
        return i == s.length() && j == s1.length();
    }
}
