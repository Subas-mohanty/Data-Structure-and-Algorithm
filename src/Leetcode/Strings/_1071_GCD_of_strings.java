package Leetcode.Strings;
//https://leetcode.com/problems/greatest-common-divisor-of-strings/description/
public class _1071_GCD_of_strings {

    // SC : O(n)
    // TC : O(n)
        public String gcdOfStrings2(String str1, String str2) {
            // Check if concatenated strings are equal or not, if not return ""
            if (!(str1 + str2).equals(str2 + str1))
                return "";
            // If strings are equal than return the substring from 0 to gcd of size(str1), size(str2)
            int gcd = gcd(str1.length(), str2.length());
            return str1.substring(0, gcd);
        }

        // this is to find the gcd of two numbers
        private int gcd(int a, int b) {
            return b == 0 ? a : gcd(b, a % b);
        }

    public String gcdOfStrings(String str1, String str2) {
        // Check if concatenated strings are equal or not, if not return ""
        if (!(str1 + str2).equals(str2 + str1)) return "";
        int m = str1.length();
        int n = str2.length();
        int i = 0;
        int j = 0;
        StringBuilder sb = new StringBuilder();
        while(i < m && j < n){
            if(str1.charAt(i) == str2.charAt(j)){
                sb.append(str1.charAt(i));
            }
            i++;
            j++;
        }
        while(!sb.isEmpty()){
            if(m % sb.length() == 0 && n % sb.length() == 0) return sb.toString();
            else sb.deleteCharAt(sb.length() -1);
        }
        return sb.toString();
    }
}
