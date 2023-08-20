package Lecture_practice_problems._25_math_for_DSA_01;

public class _03_find_ith_bit_of_a_number {
    public static void main(String[] args) {
        int num=101011101;
        System.out.println(findBit(num,2));
    }

    private static int findBit(int num,int digit) {
        return (num>>digit-1)&1;
        // num>>digit , number right shift digit-1 put the ith digit in the first position and by performing and operation on it, we can get the digit
    }
}
