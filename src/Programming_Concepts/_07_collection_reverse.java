package Programming_Concepts;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class _07_collection_reverse {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5, 1};
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        // maxHeap
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

    }
}
