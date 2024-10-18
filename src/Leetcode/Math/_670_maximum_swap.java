package Leetcode.Math;

//https://leetcode.com/problems/maximum-swap/description/?envType=daily-question&envId=2024-10-17

public class _670_maximum_swap {
    public static void main(String[] args) {
        int num = 98800435;
        System.out.println(maximumSwap(num));
    }

    // TC : O(n^2) --> n is the number of digits in the num
    // SC : O(n) --> storing all the digits in an array
    public static int maximumSwap(int num) {
        String val = Integer.toString(num);
        char [] arr = val.toCharArray();
        int n = arr.length;
        int maxSoFar = 0;
        int max = 0;
        boolean isSwap = false;

        // for each index finding the largest element present in its right, when found the largest element at an index, swap the values, the number will always be greater because we are finding the largest number for each index from the left
        for(int i = 0; i < n; i++){
            for(int j = n - 1; j > i; j--){
                if(arr[j] > arr[i] && arr[j] > maxSoFar){
                    maxSoFar = arr[j];
                    max = j;
                    isSwap = true;
                }
            }
            if(isSwap){
                char temp = arr[i];
                arr[i] = arr[max];
                arr[max] = temp;
                break; // only one swap is allowed, so after doing one swap breaking out from the loop
            }
        }

        // making the number from the character array
        int ans = 0;
        for (char c : arr) {
            ans *= 10;
            ans += c - '0';
        }
        return ans;
    }
}
