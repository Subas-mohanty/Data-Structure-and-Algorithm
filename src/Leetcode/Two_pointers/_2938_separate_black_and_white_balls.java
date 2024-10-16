package Leetcode.Two_pointers;
//https://leetcode.com/problems/separate-black-and-white-balls/description/?envType=daily-question&envId=2024-10-15
public class _2938_separate_black_and_white_balls {
    public static void main(String[] args) {
        String s = "0111";
        System.out.println(minimumSteps(s));

    }
    // brute force
    // TC : O(n^2 + n)
    // SC : O(n)
    public long minimumSteps2(String s) {
        int n = s.length();
        int [] arr = new int[n];
        // for each index, calculate the number of 0s in its right hand side
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(s.charAt(j) == '0') arr[i]++;
            }
        }
        long ans = 0;
        // multiply the characters int value with the number of zeros present in its right
        for(int i = 0; i < arr.length; i++){
            char ch = s.charAt(i);
            ans += (ch - '0') * arr[i];
        }
        return ans;
    }

    // better approach
    // TC : O(n + n + n)
    // SC : O(n)
    public static long minimumSteps(String s) {
        int n = s.length();
        int [] arr = new int[n];
        int st = 0;
        int e = n-1;
        int zeros = 0;
        for(char c : s.toCharArray()){
            if(c == '0') zeros++;
        }
        while(st < e){
            arr[st] = zeros;
            if(s.charAt(st) == '0') zeros--;
            st++;
        }

        long ans = 0;
        for(int i = 0; i < arr.length; i++){
            char ch = s.charAt(i);
            ans += (ch - '0') * arr[i];
        }
        return ans;
    }

    // optimal approach
    // TC : O(n)
    // SC : O(1)
    public static long minimumSteps3(String s) {
        long swap = 0;
        int zeroPosition = 0;
        for(int currPosition = 0; currPosition < s.length(); currPosition++){
            // if found a zero calculate the total swaps needed to shift it to left most available position
            if(s.charAt(currPosition) == '0') {
                swap += currPosition - zeroPosition;
                // Move the next available position for a white ball one step to the right
                zeroPosition++;
            }
        }
        return swap;
    }
}
