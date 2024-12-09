package Leetcode.Recursion;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/restore-ip-addresses/
public class _93_restore_ip_address {
    List<String> list = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        int n = s.length();
        if(n < 4 || n > 12) return new ArrayList<>();
        helper(s, new StringBuilder(), 0);
        return list;
    }
    // we have 3 options, either we take one digit and try to make the ip from the remaining string or we take 2 digit at a time or 3 digit at a time if they their combined value is less than or equal to 255
    void helper(String s, StringBuilder sb, int calls){
        if(s.isEmpty() && calls == 4){ // exactly 4 segmets should be taken
            list.add(sb.toString().substring(0, sb.length() - 1)); //removing the trailing '.'
            return;
        }

        if(calls > 4 || s.isEmpty()) return;

        // one digits
        sb.append(s.charAt(0)).append(".");
        helper(s.substring(1), sb, calls + 1);
        sb.deleteCharAt(sb.length() - 1); // for the digit
        sb.deleteCharAt(sb.length() - 1); // for the '.'

        // two digits
        if(s.length() >= 2 && s.charAt(0) != '0'){
            sb.append(s.substring(0, 2)).append(".");
            helper(s.substring(2), sb, calls + 1);
            sb.delete(sb.length()-3, sb.length()); // remove last 3 characters, two is for the substring and 1 is for the '.'
        }

        // three digits
        if(s.length() >= 3 && s.charAt(0) != '0' && Integer.parseInt(s.substring(0,3)) <= 255){
            sb.append(s.substring(0, 3)).append(".");
            helper(s.substring(3), sb, calls + 1);
            sb.delete(sb.length()-4, sb.length()); // remove last 3 characters, two is for the substring and 1 is for the '.'
        }

    }
}
