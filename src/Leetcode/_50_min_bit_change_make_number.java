package Leetcode;
//https://leetcode.com/problems/minimum-bit-flips-to-convert-number/description/
public class _50_min_bit_change_make_number {
    public static void main(String[] args) {
        System.out.println(minBitFlips(10,7));
        System.out.println(13>>2);
    }
    public static int minBitFlips(int start, int goal) {
        // XOR gives the number of bits that differs between two numbers
        // ex --> 10 - 1010
        //         7 - 0111
        //       XOR = 1101 , so there are 3 bits that we need to change to make 7 from 10
        int num = start^goal;
        System.out.println(num);
        int count = 0;
        while(num>0){
            if((num & 1) == 1) count++;
            num = num>>1;
        }
        return count;
    }
}
