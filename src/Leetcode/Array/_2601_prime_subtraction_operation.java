package Leetcode.Array;

import java.util.PriorityQueue;
//https://leetcode.com/problems/prime-subtraction-operation/?envType=daily-question&envId=2024-11-11
public class _2601_prime_subtraction_operation {
    // TC : O(n * k * log k * sqrt(k)) --> k is the maximum element in the array
    // SC : O(sqrt(k))
    // in the max heap we are storing prime numbers <= curr number
    public boolean primeSubOperation(int[] nums) {
        int prev = 0;
        for(int i : nums){
            // storing all prime numbers from 0 to i - 1
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
            findPrime(i, pq);


            // until we get the number greater than prev, keep removing from the queue, as we remove the prime will get smaller and our number get bigger, if we don't find a bigger number and the heap is empty than we can't get our answer
            while(i - pq.peek() <= prev){
                pq.poll();
                if(pq.isEmpty()) return false;
            }

            // if num - max-prime is > prev, this means this the smallest number which is greater than prev, smallest because we are subtracting the largest prime smaller than current number
            if(i - pq.peek() > prev){
                prev = i - pq.peek();
            }
        }
        return true;
    }
    // this function will go from num - 1 to 2 and store all the prime numbers between them in the max-heap
    void findPrime(int a, PriorityQueue<Integer> pq){
        for(int i = a - 1; i >= 2; i--){
            if(prime(i)) pq.offer(i);
        }
        // adding 0, because we need to consider case like when number is 3 and prev = 2, so there will be no prime number for 3, for which subtracting that from 3 will be < prev, so we have to have 0 at that condition and continue the check
        pq.offer(0);
    }
    boolean prime(int num){
        for(int i = 2; i * i <= num; i++){
            if(num % i == 0) return false;
        }
        return true;
    }
}
