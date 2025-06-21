package Programming_Concepts;

import java.util.Arrays;

// how to store an entire array in a single integer number
public class _16_bit_manipulation_store_array_in_a_number {
    public static void main(String[] args) {
        arrayInANumber();
    }
    public static void arrayInANumber(){
        int binaryVal = 0;
        int [] arr = {7,3,4,6};
        int max = Arrays.stream(arr).max().getAsInt();
        int blockSize = Integer.bitCount(max); // no of bits in the binary representation of the number
        for(int i = 0; i < arr.length; i++){
            binaryVal += (arr[i] << (i * blockSize));
        }
        System.out.println(binaryVal);

        // retrieve the values
        int [] ans = new int[4];
        int ind = 0;
        while(binaryVal > 0){
            int num = 0;
            for(int i = 0; i < blockSize; i++){
                int digit = binaryVal & 1;
                binaryVal = binaryVal >> 1;
                if(digit == 1) num += (int) Math.pow(2, i);
            }
            ans[ind++] = num;
        }
        System.out.println(Arrays.toString(ans));
    }
}
