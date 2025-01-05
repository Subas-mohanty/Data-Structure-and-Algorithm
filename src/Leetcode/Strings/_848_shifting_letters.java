package Leetcode.Strings;

//https://leetcode.com/problems/shifting-letters/description/

public class _848_shifting_letters {
    // TC : O(N + N)
    // SC : O(N) --> asked in the question
    // observation ->
    // each character is modified multiple times, once for its turn and again for its next index's turn
    // here we find a thing that the first character is modified total sum of shift number of times and second character is modified sum [1-end], and so on
    // so just go to each character and find the number of times it needs to get modified then replace the current character with the new one
    public String shiftingLetters(String s, int[] shifts) {
        long sum = 0;
        int n = s.length();
        for(int a : shifts) sum += a;
        StringBuilder sb = new StringBuilder(s);

        for(int i = 0; i< n; i++){
            replace(sb, i, sum);
            sum -= shifts[i];
        }
        return sb.toString();
    }
    void replace(StringBuilder sb, int ind, long freq){
        char curr = sb.charAt(ind);
        // finding the index value of curr character with this (curr - 'a')
        // adding freq and mod with 26 will give the new chars index now add with 'a' to find the character
        char ch = (char) ( 'a' + (curr - 'a' + freq) % 26 );
        sb.setCharAt(ind, ch); // set the character at the current index
    }
}
