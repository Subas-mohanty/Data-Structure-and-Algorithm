package Leetcode.Sliding_Window;

//https://leetcode.com/problems/grumpy-bookstore-owner/?envType=daily-question&envId=2024-06-21
public class _1052_grumpy_bookstore {
    public static void main(String[] args) {
        int [] customers = {402,5,120,689,283,691,311,43,684,994,171,816,512,242,980,929,814,610,188,806,118,971,748,299,581,571,503,787,804,469,144,355,619,89,367,535,916,52,964,770,102,792,384,430,491,169,928,547,184,341};
        int [] grumpy = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        int minutes = 28;
        System.out.println(maxSatisfied(customers, grumpy, minutes));
    }
    public int maxSatisfied2(int[] customers, int[] grumpy, int minutes) {
        int n = grumpy.length;
        int initial = 0;
        int maxAfter = 0;
        int current = 0;

        for(int i = 0; i < n; i++){
            if(grumpy[i] == 0) initial += customers[i];
            else if(i < minutes) current += customers[i]; // this is the sum of first window
        }

        for(int i = minutes; i < n; i++){
            current += customers[i] * grumpy[i]; // adding the next element to the current
            current -= customers[i - minutes] * grumpy[i - minutes]; // removing the first element of the previous window, for ex : first window 1 0 2, next we add 3 so, we have to remove 1
            maxAfter = Math.max(current, maxAfter);
        }

        return initial + maxAfter;
    }


    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int s = 0;
        int e = minutes - 1;
        int initial = 0;
        int maxSum = 0;

        for(int i = 0 ; i<= n - minutes; i++){
            // finding sum of all window of size minutes and taking max that means, this is the value we need to add to the initial sum to get the answer
            int sum = findSum(customers,grumpy, s , e);
            if(sum > maxSum){
                maxSum = sum;
            }
            s++;
            e++;
        }

        // initial sum where grumpy is 0
        for(int i = 0; i< n; i++){
            if(grumpy[i] == 0){
                initial += customers[i];
            }
        }
        return initial + maxSum;
    }

    // finding sum of a window of size minutes, where grumpy is 1
    public static int findSum(int [] arr, int [] grm, int s, int e){
        int ans =0;
        for(int i = s; i<=e ; i++){
            if(grm[i] == 1) ans += arr[i];
        }
        return ans;
    }
}
