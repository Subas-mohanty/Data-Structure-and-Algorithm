package Leetcode;
//https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/
// question explanation --> we are given an array, consider each element in the as a flower and that flower blooms in that day, ex : {1,10,3,10,2} , on first day only one element is bloom {x, -, -, -, -}
// on second day : {x, -, -, -, x}
// on third day : {x, -, x, -, x}
// on tenth day : {x, x, x, x, x}

// we are also given an integer m and k, we have to make m bouquets, having k flowers on each bouquet and one more condition is k elements need to be adjacent;

// we have to return the min number of days in which we can make m bouquets

public class _74_minDays_to_make_m_bouquets {
    public static void main(String[] args) {
        int [] arr = {1,10,3,10,2};
        int m = 3, k = 1;
        System.out.println(minDays(arr, m, k));
    }
    public static int minDays(int[] bloomDay, int m, int k) {
        int minEl = (int)1e9;
        int maxEl = 0;

        // finding the min and max element of the array, because at the max day all flowers will have bloomed so, we can make all bouquets, and our answer lies between min and max , so we can do a binary search to find the answer
        for(int i : bloomDay){
            if(i > maxEl) maxEl = i;
            else if(i < minEl) minEl = i;
        }
        return days(bloomDay, m, k, minEl, maxEl);
    }
    public static int days(int [] arr, int m, int k, int min, int max){
        int ans = -1;

        // binary search
        while(min <= max){
            int mid = min + (max-min)/2;
            if(bloom(arr, m, k, mid)){ // this is to check whether till this day we can fill our bouquets or not, if yes then marking that day as temporary ans and going to left to find if any other answer is possible or not
                ans = mid;
                max = mid-1;
            }
            else min = mid+1;
        }
        return ans;
    }
    public static boolean bloom(int [] arr, int m, int k, int days){
        int count = 0;
        for(int i = 0; i<arr.length; i++){
            if(arr[i] <= days) count++; // increasing count till element is less than the day

            // if k adjacent element is present than decreasing bouquet by one because we made one bouquet and making count again 0
            if(count == k) {
                m--;
                count = 0;
            }
            // if at any time we get greater element than making count = 0 again to find adjacent element again
            if(arr[i] > days) count = 0;
        }

        return m <= 0;
    }
}
