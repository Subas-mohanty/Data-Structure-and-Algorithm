package Leetcode;

import java.util.ArrayList;
//https://shorturl.at/ruKNY
public class _80_painters_partition {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(8);
        list.add(6);
        list.add(10);
        list.add(3);
        list.add(2);
        list.add(7);
        list.add(10);

        int k = 7;
        System.out.println(paintersPartition(list, k));

        System.out.println(canPaint(list, 23, k));
    }
    public static int paintersPartition(ArrayList<Integer> boards, int k){
        if(boards.size() == 1) return boards.get(0);
        if(boards.size() == 2) return Math.max(boards.get(0), boards.get(1));

        int sum = 0;
        int max = 0;
        for(int i = 0; i < boards.size(); i++) {
            if(boards.get(i) > max) max = boards.get(i);
            sum += boards.get(i);
        }

        int high = sum;
        int low = max;

        int ans = -1;
        while(low <= high){
            int mid = low+(high-low)/2;
            if(canPaint(boards, mid, k)){
               ans = mid;
               high = mid-1;
            }
            else low = mid+1;
        }
        return ans;
    }
    public static boolean canPaint(ArrayList<Integer> boards, int mid, int k){

        int tempSum = 0;
        int countPainter = 1;
        for (int i = 0; i < boards.size(); i++) {
           if(tempSum+boards.get(i) <= mid) tempSum += boards.get(i);
           else{
              countPainter++;
              tempSum = boards.get(i);
           }
        }
        return countPainter <= k;
    }
}
