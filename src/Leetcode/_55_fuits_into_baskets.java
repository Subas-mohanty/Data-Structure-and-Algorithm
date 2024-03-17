package Leetcode;

import java.util.HashMap;

public class _55_fuits_into_baskets {
    public static void main(String[] args) {
        int [] arr = {1,2,3,1,1,2,3,4};
        System.out.println(fruits(arr));
    }
    public static int fruits(int []arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int j = 0;
        int max = 0;

        for (int i = 0; i < arr.length ; i++) {
            int count = map.getOrDefault(arr[i], 0);
            map.put(arr[i] , count + 1);


            // if basket has more than two types of fruit, start emptying the basket
            while(map.size() > 2){
              int removed = map.get(arr[j]);

              // if its occurrence is one just remove it or decrease the value by 1
              if(removed == 1 ){
                  map.remove(arr[j]);
              }
              else {
                  map.put(arr[j], removed - 1);
              }
              j++;
            }
            max = Math.max(max, i-j+1);
        }
        return max;
    }
}
