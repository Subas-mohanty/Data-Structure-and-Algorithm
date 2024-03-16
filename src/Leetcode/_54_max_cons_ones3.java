package Leetcode;
//https://leetcode.com/problems/max-consecutive-ones-iii/description/
public class _54_max_cons_ones3 {
    public static void main(String[] args) {
        int [] arr= {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
//        System.out.println(ones(arr));

        System.out.println(ones3(arr, 3));
    }

    // maximum number of consecutive ones
    public static int ones(int[] arr) {
        int count = 0;
        int max = 0;

        int ind = 0;
        while (ind < arr.length) {
            if (arr[ind] == 1) {
                count++;
            } else count = 0;
            max = Math.max(max, count);
            ind++;
        }
        return max;
    }

    // maximum number of consecutive ones by flipping k 0s into 1
    // we can flip k 0s into 1 so, we have to find the longest sub array which has k 0s
    public static int ones3(int[] arr, int k) {
        int count = 0;
        int max = 0;

        int i = 0;
        int j = 0;
        while (i < arr.length && j < arr.length) {
            // when found 0 increase the count
            if (arr[i] == 0) {
                count++;
            }
            i++;
            // when the count exceeds the max limit , decrease the count using the j pointer, when encounter a 0 decrease it by 1 else move forward
            if (count > k) {
                if (arr[j] == 0) {
                    count--;
                }
                j++;
            }
            int dist = i - j;
            max = Math.max(max, dist);
        }
        return max;
    }
}
