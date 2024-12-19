package Leetcode.Array;
//https://leetcode.com/problems/max-chunks-to-make-sorted/description/?envType=daily-question&envId=2024-12-19
public class _769_make_chunks_to_make_array_sorted {
    // TC : O(n)
    // SC : O(1)
    public int maxChunksToSorted(int[] arr) {
        int max = 0;
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            max = Math.max(max, arr[i]);
            if(max < i + 1) count++;
        }
        return count;
    }

//    The best way to do this is to think that as all the numbers are unique and we know the size of array, so we know all elements in the array. so, we know that in the sorted array arr[i] = i, it means that if we compute a running sum of elements in the array, then if at any moment, the sum = i*(i+1)/2, then we should make a partition at that point. continuing this process will give us the max no. of partitions.
//    like :        1, 0, 2, 3, 4
//    running sum : 1, 1, 3, 6, 10
//    i*(i+1)/2 :   0, 1, 3, 6, 10
//    for this, sum = i*(i+1)/2 condition is correct 4 times, so answer is 4
    // TC : O(n)
    // SC : O(1)
    public int maxChunksToSorted2(int[] arr) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++){
            sum += arr[i];
            int t = (i * (i + 1)) / 2;
            if(sum == t) count++;
        }
        return count;
    }
}
