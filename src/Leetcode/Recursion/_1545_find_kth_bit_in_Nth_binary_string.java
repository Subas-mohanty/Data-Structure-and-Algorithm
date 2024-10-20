package Leetcode.Recursion;
//https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/description/?envType=daily-question&envId=2024-10-19
public class _1545_find_kth_bit_in_Nth_binary_string {
    // TC : O(n * 2^n-1) --> the invert function will run 2^n-1 times
    // SC : O(2 ^ n -1)

    // s1 = "0" --> 1 ( 2 ^ 1 - 1)
    // s2 = s1 + "1" + reverse(s1) --> 3 ( 2 ^ 2 - 1)
    // sn = sn-1 + "1" + reverse(sn-1) --> 2^n-1

    // TC : O(2n)
    public char findKthBit2(int n, int k) {
        int len = (int)Math.pow(2, n) - 1; // length of nth string
        return helper(len, k);
    }
    char helper(int len, int k){
        // base case
        if(len == 1) return '0';
        int half = len/2;
        // for length = 15, mid will be 8, 7 on the left and 7 on the right
        int middle = len/2 + 1;
        // middle character will always be 1, so if k == middle return 1
        if(middle == k) return '1';
        // char is present in left side so check in the left part
        if(k < middle) return helper(half, k);

        // char is present in right
        char ans = helper(len, len - k + 1); // find the corresponding char in left
        return ans == '1' ? '0' : '1';
    }


    public char findKthBit(int n, int k) {
        String prev = "0";
        String curr = "";
        while(n > 0){
            String invert = invert(prev);
            String reverse = new StringBuilder(invert).reverse().toString();
            curr = prev + "1" + reverse;
            prev = curr;
            n--;
        }
        return curr.charAt(k-1);
    }
    // invert the string, make 0s 1 and 1s 0
    String invert(String s){
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(ch == '0') sb.append('1');
            else sb.append('0');
        }
        return sb.toString();
    }
}
