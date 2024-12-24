package Leetcode.Heap;

import java.util.HashMap;
import java.util.PriorityQueue;
//https://leetcode.com/problems/sort-characters-by-frequency/description/
public class _451_sort_characters_by_frequency {

    public static void main(String[] args) {
        String s = "ssssuuubbbbbbbbAS";
//        System.out.println(frequencySort(s));
        System.out.println(helper(s));

        Solution sl = new Solution();
        String ans = sl.frequencySort(s);
        System.out.println(ans);
    }
    static class Pair{
       int freq;
       char ch;
       public Pair(int freq, char ch){
           this.ch = ch;
           this.freq = freq;
       }
    }
    public static String helper(String s){
       int [] countArr = new int[128];
       // we have given a lambda function as a comparator to the PriorityQueue, as it is of type Pair so we are giving two Pair object and returning or sorting based on the frequency property of the Pair class
       PriorityQueue<Pair> pq = new PriorityQueue<>(((a, b) -> b.freq - a.freq));

       // build the count array
        for (char c : s.toCharArray()) {
           countArr[c]++;
        }

        // build the priority queue
        for (int i = 0; i < 128; i++) {
           if(countArr[i] > 0) pq.add(new Pair(countArr[i], (char) i));
        }

        StringBuilder str = new StringBuilder();

        while(!pq.isEmpty()){
            Pair top = pq.poll();
            for (int i = 0; i < top.freq; i++) {
               str.append(top.ch);
            }
        }
        return str.toString();
    }

    static class Solution {
        public String frequencySort(String s) {
            int n = s.length();
            HashMap<Character, Integer> hs = new HashMap<>();
            StringBuilder str = new StringBuilder();

            for (int i = 0; i < n; i++) {
                if (hs.containsKey(s.charAt(i))) {
                    hs.put(s.charAt(i), hs.get(s.charAt(i)) + 1);
                } else {
                    hs.put(s.charAt(i), 1);
                }
            }

            PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> hs.get(b) - hs.get(a));
            pq.addAll(hs.keySet());

            while (!pq.isEmpty()) {
                char ch = pq.poll();
                int value = hs.get(ch);

                for (int i = 0; i < value; i++) {
                    str.append(ch);
                }
            }

            return str.toString();
        }
    }}
