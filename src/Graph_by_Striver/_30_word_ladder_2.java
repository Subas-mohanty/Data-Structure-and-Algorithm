package Graph_by_Striver;

import java.util.*;
//http://leetcode.com/problems/word-ladder-ii/
//https://youtu.be/DREutrv2XD0?si=7E0OBBxxcI4VerRw
// come again to this problem after learning graph very well

public class _30_word_ladder_2 {
    public List<List<String>> ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Creating a queue ds of type {word,transitions to reach ‘word’}.
        Queue<List<String>> q = new LinkedList<>();

        // Push all values of wordList into a set
        // to make deletion from it easier and in less time complexity.
        Set<String> set = new HashSet<>(wordList);
        List<List<String>> ans = new ArrayList<>();

        // pushing just the beginword into the queue
        List<String> temp = new ArrayList<>();
        temp.add(beginWord);
        q.offer(temp);

        List<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(beginWord);
        int level = 0;

        while(!q.isEmpty()) {
            List<String> lastList = q.poll();

            // deleting all words that has been used on previous levels to transform
            if(lastList.size() > level){
                level++;
                for(String s : usedOnLevel) set.remove(s);
            }
            String word = lastList.getLast();

            // store the answers if the end word matches with targetWord.
            if (word.equals(endWord)) {
                // the first sequence where we reached the end.
                if (ans.isEmpty()) {
                    ans.add(lastList);
                }
                // this is to check if the current list is of same size as the previously present list, because we only want the shortest number of transformation, and once we found it, if multiple answer is present then they must have same length as of previous list not greater not smaller
                else if (ans.get(0).size() == lastList.size()) {
                    ans.add(lastList);
                }
            }
            // changing the character of each word
            // for eg- pot --> aot, bot, cot...., pat, pbt, pct... poa, pob, poc.....
            for (int j = 0; j < word.length(); j++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    String newWord = word.substring(0, j) + ch + word.substring(j + 1);
                    if (set.contains(newWord)) {
                        // adding the newWord to the list
                        lastList.add(newWord);
                        List<String> newL = new ArrayList<>(lastList);
                        q.offer(newL); // adding the list to the queue

                        // mark as visited on the level
                        usedOnLevel.add(newWord);

                        // backtracking
                        lastList.removeLast();
                    }
                }
            }
        }
        return ans;
    }
}
