package Programming_Concepts;
import java.util.*;

public class _13_bucket_sort {
    // TC : O(n + k) --> best case, when all the elements are uniformly distributed
    // O(nlogn) --> in the worst case, when all elements fall into one bucket and sorting takes nlogn
    // SC : O(n) --> all the buckets store total of n elements combined
    public static void main(String[] args) {
        int[] nums = {3,2,42,9,17};
        bucketSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void bucketSort(int[] nums) {
        int n = nums.length;
        if (n <= 1) return;

        // Step 1: Find min and max
        int min = Arrays.stream(nums).min().getAsInt();
        int max = Arrays.stream(nums).max().getAsInt();

//        int bucketCount = (int) Math.sqrt(nums.length); // this we can decide with some better formula as well
//        int bucketSize = (max - min) / bucketCount + 1;

        int bucketSize = (int) Math.ceil((double) (max - min) / (n-1));
        int bucketCount = (max - min) / bucketSize + 1; // no of buckets

        // Step 2: Create and fill the buckets
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }

        for (int num : nums) {
            int index = (num - min) / bucketSize;
            buckets.get(index).add(num);
        }

        // Step 3: Sort each bucket and concatenate
        int index = 0;
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket); // You can use insertion sort if needed
            for (int num : bucket) {
                nums[index++] = num;
            }
        }
    }

}
