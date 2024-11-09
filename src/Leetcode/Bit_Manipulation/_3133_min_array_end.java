package Leetcode.Bit_Manipulation;

//https://leetcode.com/problems/minimum-array-end/description/?envType=daily-question&envId=2024-11-09


// You are given two integers n and x. You have to construct an array of positive integers nums of size n where for every 0 <= i < n - 1, nums[i + 1] is greater than nums[i], and the result of the bitwise AND operation between all elements of nums is x. Return the minimum possible value of nums[n - 1].
// so what are we doing here ?
// we have to form an array like this
// [a,b,c,d] where a & b & c & d = x
// one thing we know that AND between any two number is less than or equal to the smaller number,
// so if we want to form an sorted array we have to take the x as the first number itself
// now to get the next number which will give result as x when AND with x we will do the following
// take the next number, for ex : for 5 take 6, but it may or may not give AND = x, so we have to OR it with x to get the next number, now the OR result is 7, so the new number is 7, now find the next number, with doing x OR with 8


public class _3133_min_array_end {
    // TC : O(n)
    // SC : O(1)
    public long minEnd(int n, int x) {
        long ans = x;
        for(int i = 1; i< n; i++){
            ans = (ans + 1) | x;
        }
        return ans;
    }
}
