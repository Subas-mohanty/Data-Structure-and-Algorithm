package Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
//https://leetcode.com/problems/my-calendar-ii/description/?envType=daily-question&envId=2024-09-27
//https://www.youtube.com/watch?v=TbHCvF4GOVE&t=695s

class _731_myCalender_2{
    class MyCalendarTwo {
        List<int[]> list;
        TreeMap<Integer, Integer> map; // storing intervals which has occured 2 times

        public MyCalendarTwo() {
            this.map = new TreeMap<>();
            this.list = new ArrayList<>();
        }

        public boolean book(int start, int end) {
            Integer prevVal = map.lowerKey(end);
            // this interval is present in map, and in map we are storing the intervals which has occured 2 times
            if(prevVal != null && start < map.get(prevVal)) return false;

            for(int [] arr : list){
                int newS = arr[0];
                int newE = arr[1];
                int commonS = Math.max(start, newS);
                int commonE = Math.min(end, newE);

                // if there is already a booking in the list and again we find booking which overlaps, this means we have 2 overlaps now so adding the interval to the map
                if(commonS < commonE){
                    map.put(commonS, commonE);
                }
            }
            list.add(new int[]{start, end});
            return true;
        }
    }
}