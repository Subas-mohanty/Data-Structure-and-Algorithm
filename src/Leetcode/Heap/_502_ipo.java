package Leetcode.Heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
//https://leetcode.com/problems/ipo/description/?envType=daily-question&envId=2024-06-15

public class _502_ipo {
    public static void main(String[] args) {
        int k = 2;
        int w = 0;
        int [] profits = {1,2,3};
        int [] capital = {0,1,1};
        System.out.println(findMaximizedCapital(k, w, profits, capital));
    }
    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = capital.length;
        Pair[] pair = new Pair[n];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // creating the pair array
        for(int i = 0; i < n; i++){
            pair[i] = new Pair(profits[i], capital[i]);
        }
        Arrays.sort(pair);

        int j = 0;
        for(int i = 0; i < k; i++){
            while(j < n && w >= pair[j].b){
                // storing the profits in a max Heap to get the maximum profits
                maxHeap.add(pair[j].a);
                j++;
            }
            // if no element has been added to the maxHeap, that means there are no profits
            if(maxHeap.isEmpty()) break;

            w += maxHeap.poll();
        }
        return w;
    }


    static class Pair implements Comparable<Pair>{
        int a;
        int b;
        Pair(int a, int b){
            this.a = a;
            this.b = b;
        }
        public int compareTo(Pair o){
            return this.b - o.b;
        }
    }
}