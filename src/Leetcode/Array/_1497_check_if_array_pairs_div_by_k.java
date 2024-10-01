package Leetcode.Array;
//https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/description/?envType=daily-question&envId=2024-10-01
public class _1497_check_if_array_pairs_div_by_k {

    // TC : O(n + k/2)
    // SC : O(k)

    // some maths :
    // if a + b is divisible by k or (a+b) % k == 0
    // then (a % k) + (b % k) == k
    public boolean canArrange(int[] arr, int k) {
        // we are storing the frequency of remainders for each element in the array
        int [] count = new int[k];
        for(int a : arr){
            // int rem = a % k; but this will not work for negative numbers, e.g, if a == -1 then the remainder will be -1, and we are accessing a negative index in the next line so it will give an error
            int rem = (a%k + k) % k; // this is for negative remainder
            count[rem]++;
        }
        if(count[0] % 2 != 0) return false; // if the remainder is 0 then don't check for counterHalf, because it will go out of bound, and we don't need to check that, because if and element is divisible by 0, it's counterHalf should also be divided by 0, so the frequency should be even in case of remainder 0
        // we don't have go till k, as the complement will repeat after k/2, if k=5, then the complement of 1 and 2 are 4 and 3 , so we don't have to check for the complement when we have already checked them
        for(int rem = 1; rem <= k/2; rem++){
            int counterHalf = k - rem;
            // if any pair doesn't have a subsequent complement then we can't make the pair
            if(count[counterHalf] != count[rem]) return false;
        }
        return true;
    }
}
