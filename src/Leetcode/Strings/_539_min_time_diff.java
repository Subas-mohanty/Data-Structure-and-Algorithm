package Leetcode.Strings;

// https://leetcode.com/problems/minimum-time-difference/?envType=daily-question&envId=2024-09-16
// https://www.youtube.com/watch?v=H9RSXyF0SHs

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _539_min_time_diff {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> time = new ArrayList<>();

        // converting string (HH:MM) to minutes
        for(String s : timePoints){
            if(s.substring(0, 2).equals("00")){
                int min = Integer.parseInt(s.substring(3, 5));
                time.add(24*60 + min);
            }
            else{
                int hour = Integer.parseInt(s.substring(0,2));
                int min = Integer.parseInt(s.substring(3, 5));

                time.add((hour * 60) + min);
            }
        }
        // sort the time and check for every consicutive pairs
        Collections.sort(time);
        int min = (int)1e9;
        for(int i = 1; i < time.size(); i++){
            min = Math.min(min, time.get(i) - time.get(i-1));
        }
        // as the time is circular, we have to check for first and last as well
        int lastDiff = Math.abs(1440 + time.get(0) - time.getLast());
        return Math.min(min, lastDiff);
    }


   public int findMinDifference2(List<String> timePoints) {
        boolean [] bucket = new boolean[1440];

        // using bucket sort
        // storing all the minutes in the bucket array , then traverse it to find the min difference
        // converting string (HH:MM) to minutes
        for(String s : timePoints){
            int hour = Integer.parseInt(s.substring(0,2));
            int min = Integer.parseInt(s.substring(3, 5));
            int minutes = hour * 60 + min;
            if(bucket[minutes]) return 0; // same time occur twice so the min diff will be 0
            bucket[minutes] = true;
        }
        int min = (int)1e9;
        int prev = -1;
        int firstValue = 0;
        for(int i = 0; i < 1440; i++){
            if(bucket[i]){
                if(prev == -1){
                    prev = i;
                    firstValue = i;
                }
                else{
                    min = Math.min(min, i - prev);
                    prev = i;
                }
            }
        }
        // as the time is circular, we have to check for first and last as well
        if(prev != -1){
            min = Math.min(min, 1440 + firstValue - prev);

        }
        return min;
    }}
