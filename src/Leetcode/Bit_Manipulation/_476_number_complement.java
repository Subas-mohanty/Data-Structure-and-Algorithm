package Leetcode.Bit_Manipulation;

//https://leetcode.com/problems/number-complement/?envType=daily-question&envId=2024-08-22

public class _476_number_complement {
    public static void main(String[] args) {
        int n = 2147483647;
        System.out.println(findComplement(n));
    }
    public static int findComplement(int num) {
        if(num == 0) return 1; // for 0, it's complement will be 1, it will not be passed in the main code, because, for 0, count will be 0, and mask will be 0, and 0 ^ 0 (num ^ mask) will give result as 0, which is wrong
        int count = 0;
        int temp = num;
        // find number of bits in the number

        // this also gives the number of bits in a number
        // count = Integer.toBinaryString(num).length();
        while(temp != 0){
            temp = (temp >> 1);
            count++;
        }

        // XOR the num with all 1's , the number of 1's should be equal to number of bits in the number
        // if we do only this , (int) Math.pow(2, count) - 1;
        // for num = 2147483647, count will 31 and the pow will come as out of bound, so converting to int will give 2147483647 and then when we subtract it will give 2147483646, which is wrong
        // instead of power we can use shift operator, like this (1 << count) - 1;
        int mask = (int) (Math.pow(2, count) - 1);
        return num ^ mask;
    }
}
