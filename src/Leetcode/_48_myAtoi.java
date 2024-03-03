package Leetcode;
//https://leetcode.com/problems/string-to-integer-atoi/description/
public class _48_myAtoi {
    public static void main(String[] args) {
        String s = "4193 with words";
        System.out.println(myAtoi(s));
    }
    public static int myAtoi(String str) {
        boolean negative = false;
        long num = 0;
        String s = str.trim();

        for(int i =0; i<s.length();i++){
            char ch = s.charAt(i);
            if(i == 0){
                if(ch == '-') {
                    negative = true;
                    continue;
                }
                else if(ch == '+') {
                    negative = false;
                    continue;
                }
            }
            if((ch - 0) >= 48  && (ch - 0) <= 57 ){
                int dig = ch - '0';
                num = num * 10 +dig;

                if (negative) {
                    long check = -num;
                    if(check < Integer.MIN_VALUE){
                        return Integer.MIN_VALUE;
                    }
                }else{
                    if(num > Integer.MAX_VALUE){
                        return Integer.MAX_VALUE;
                    }
                }
            }
            else{
                break;
            }
        }

        return negative ? (int)-num : (int)num;
    }
}
