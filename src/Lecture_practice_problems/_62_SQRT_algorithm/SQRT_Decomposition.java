package Lecture_practice_problems._62_SQRT_algorithm;

import java.util.Arrays;

public class SQRT_Decomposition {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 2, 7, 6, 1, 4, 8};
        int n = arr.length;
        int sqrt = (int) Math.sqrt(n);
        int block_id = -1;

        // blocks array creation
        int[] blocks = new int[sqrt + 1];

        for (int i = 0; i < n; i++) {
            // incrementing the blocks array index after every sqrt no of elements passed
            if (i % sqrt == 0) {
                block_id++;
            }
            blocks[block_id] += arr[i];
        }
//        System.out.println(Arrays.toString(blocks));
        System.out.println(query(blocks, arr, 2, 7, sqrt));
    }

    public static int query(int[] blocks, int[] arr, int left, int right, int sqrt) {
        int sum = 0;
        // left part
        while (left <= right && left % sqrt != 0) {
            sum += arr[left];
            left++;
        }
        // middle part
        while (left + sqrt <= right) {
            sum += blocks[left / sqrt];
            left += sqrt;
        }
        // right part
        while (left < right) {
            sum += arr[left];
            left++;
        }
        return sum;
    }

    public static void update(int[] arr, int[] blocks, int index, int value, int sqrt) {
        int block_id = index / sqrt;
        blocks[block_id] += (value - arr[index]);
        arr[index] = value;
    }
}
