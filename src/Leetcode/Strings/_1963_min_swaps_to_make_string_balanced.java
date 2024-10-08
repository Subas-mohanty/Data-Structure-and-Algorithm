package Leetcode.Strings;
//https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/description/?envType=daily-question&envId=2024-10-08

public class _1963_min_swaps_to_make_string_balanced {
    public int minSwaps(String s) {
        int size = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '[')
                size++;
            else if (size > 0)
                size--;
        }
        return (size + 1) / 2;
    }
}
