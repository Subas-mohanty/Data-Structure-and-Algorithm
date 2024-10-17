package Leetcode.Heap;

import java.util.PriorityQueue;
//https://leetcode.com/problems/longest-happy-string/description/?envType=daily-question&envId=2024-10-16
public class _1405_longest_happy_string {
    // TC : O(a + b+ c)
    // SC : O(1)
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        // adding the count of each letter if they are greater than 0
        if(a > 0) pq.offer(new Pair('a', a));
        if(b > 0) pq.offer(new Pair('b', b));
        if(c > 0) pq.offer(new Pair('c', c));

        while(!pq.isEmpty()){
            // poll the first element, which has the largest frequency, use that character first
            Pair pair = pq.poll();
            char ch = pair.c;
            int count = pair.count;
            // if the curr character is equal to previous second character that means it has been used 2 times and it can't be used further
            if(sb.length() >= 2 && sb.charAt(sb.length() - 1) == ch && sb.charAt(sb.length() - 2) == ch){
                if(pq.isEmpty()) break; // no valid character to use

                // poll the next character which has larger frequency
                Pair next = pq.poll();
                char ch2 = next.c;
                int count2 = next.count;
                sb.append(ch2);
                count2--;
                if(count2 > 0) pq.offer(new Pair(ch2, count2));
                pq.offer(pair); // push the polled pair again to the queue
            }
            // take the current character and add in the string
            else{
                sb.append(ch);
                count--;
                if(count > 0) pq.offer(new Pair(ch, count));
            }
        }
        return sb.toString();
    }
    class Pair implements Comparable<Pair> {
        char c;
        int count;
        public Pair(char c, int count){
            this.c = c;
            this.count = count;
        }
        // to sort in decreasing order by comparing the count
        public int compareTo(Pair a){
            return a.count - this.count;
        }
    }
}
