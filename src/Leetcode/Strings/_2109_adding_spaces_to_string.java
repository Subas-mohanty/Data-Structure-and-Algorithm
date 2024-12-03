package Leetcode.Strings;

public class _2109_adding_spaces_to_string {
    // TC : O(s * n) --> s = spaces.length && n = s.length
    // because the insert function shift all the characters to the right after inserting an element so in the worst case it will do n shift
    // SC : O(N)

    public static String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder(s);
        // int ind = 0;
        // for(int i : spaces){
        //     sb.insert(i + ind++, " ");
        // }
        // after every insertion in sb, the next insertition index will be ahead by 1
        for(int i = 0; i < spaces.length; i++){
            sb.insert(spaces[i] + i, " ");
        }
        return sb.toString();
    }

    // TC : O(n) --> append() take constant time
    // SC : O(n)
    public static String addSpaces2(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int ind = 0;
        for(int i = 0; i < s.length(); i++){
            // ind is inside bound and if the current index is where we need to add a space then add it
            if(ind < spaces.length && i == spaces[ind]){
                sb.append(" ");
                ind++;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
