package Leetcode.Strings;

//https://leetcode.com/problems/construct-string-with-repeat-limit/description/?envType=daily-question&envId=2024-12-17

public class _2182_construct_string_with_repeat_limit {
    public static void main(String[] args) {
        String s = "cczazcc";
        int r = 3;
        System.out.println(repeatLimitedString(s, r));
    }
    // TC : O(n + n * 26)
    // SC : O(26)
    public static String repeatLimitedString(String s, int repeat) {

        int [] arr = new int[26]; // store the frequency of each character
        for(char ch : s.toCharArray()) arr[ch - 'a']++;
        StringBuilder sb = new StringBuilder();
        int index = 25; // start from char 'z'
        while(index >= 0){
            // find the character whose frequency is not 0, means it is present in the original string
            while(index >= 0 && arr[index] == 0) index--;
            if(index == -1) break;

            // how many characters we can take
            int min = Math.min(repeat, arr[index]);
            // append them to the string
            for(int i = 0; i < min; i++){
                sb.append((char)('a' + index));
            }
            arr[index] -= min; // update the frequency

            // more occurrence of the character is present
            if(arr[index] > 0){
                int j = index - 1;
                // find the second-largest character
                while(j >= 0 && arr[j] == 0){
                    j--;
                }
                if(j == -1) return sb.toString();
                sb.append((char)('a' + j));
                arr[j]--;
            }
            else index--;
        }
        return sb.toString();
    }
}
