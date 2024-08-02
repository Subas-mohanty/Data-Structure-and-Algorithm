package Graph_by_Striver;

import java.util.*;
//https://leetcode.com/problems/word-ladder/
//https://www.youtube.com/watch?v=tRPda0rcf8E&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=29
public class _29_word_ladder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Creating a queue ds of type {word,transitions to reach ‘word’}.
        Queue<Pair> q = new LinkedList<>();

        // Push all values of wordList into a set
        // to make deletion from it easier and in less time complexity.
        Set<String> set = new HashSet<>(wordList);
        q.offer(new Pair(beginWord, 1));
        set.remove(beginWord);

        while(!q.isEmpty()){
            String word = q.peek().first;
            int steps = q.poll().second;

            // we return the steps as soon as
            // the first occurrence of targetWord is found.
            if (word.equals(endWord)) return steps;

            // Now, replace each character of ‘word’ with char
            // from a-z then check if ‘word’ exists in wordList.
            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    // adding ch at ith position
                    String newWord = word.substring(0, i) + ch + word.substring(i+1);
//                     char [] arr = word.toCharArray();
//                     arr[i] = ch;
//                     String newWord = new String(arr);

                    // check if it exists in the set and push it in the queue.
                    if(set.contains(newWord)){
                        set.remove(newWord);
                        q.offer(new Pair(newWord, steps+1));
                    }
                }
            }
        }
        // if no answer is found then return 0
        return 0;
    }

    class Pair{
        String first;
        int second;
        public Pair(String first, int second){
            this.first = first;
            this.second = second;
        }
    }
}
