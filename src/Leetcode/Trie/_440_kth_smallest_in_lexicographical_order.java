package Leetcode.Trie;
//https://leetcode.com/problems/k-th-smallest-in-lexicographical-order/?envType=daily-question&envId=2024-09-22

// What we are doing in this problem is we have to find the kth smallest number after lexicographically sorting numbers from 1 to n ?
// we can't solve this problem with the approach of find the sorted order and return the kth number, because the constraint is high
// how do we optimize it ?
// we will start from number 1 and start checking lexicographically and at each step we will check how many numbers are present in this numbers subtree(please look at leetcode 386 problem)
// if total numbers in the subtree, including the curr num, is <= k, that means kth smallest is not present in that sub tree, so we move to right side, and don't move to the down and we subtract the number of elements present in the subtree from k
// if it exceeds that means the kth smallest number is present inside this subtree, so explore it

public class _440_kth_smallest_in_lexicographical_order {

    // TC : O(log n ^ 2)
    // SC : O(1)
    public int findKthNumber(int n, int k) {
        int num = 1;
        k--; // to make it 0 based index

        while(k > 0){
            int step = helper(n, num); // finding number of element in the subtree of num
            // if kth smallest is not present in this subtree
            if(step <= k){
                num++;
                k -= step; // the number of element present in the subtree will be smaller than the element on the right, so when we consider right, right will be k - step th smallest
            }
            // kth smallest present in the subtree, so explore it
            else{
                num *= 10;
                k--;
            }
        }
        return num;
    }
    // this helper function will check how many numbers are present below the curr numbers subtree
    int helper(int n, int curr){
        int res = 0;
        int next = curr + 1;

        while(res <= n){
            res += Math.min(next, n + 1) - curr;
            curr *= 10;
            next *= 10;
        }
        return res;
    }
}
