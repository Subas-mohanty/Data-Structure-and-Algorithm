package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _64_unionOf_sets {
    public static List< Integer > sortedArray(int []a, int []b) {
        List<Integer> list = new ArrayList<>();
        list.add(Integer.MIN_VALUE);
        int i = 0;
        int j = 0;

        while(i < a.length && j < b.length){
            if(a[i] < b[j]){
                if(!list.isEmpty() && list.getLast() != a[i]){
                    list.add(a[i]);
                }
                i++;
            }else if(a[i] > b[j]){
                if(!list.isEmpty() && list.getLast() != b[j]){
                    list.add(b[j]);
                }
                j++;
            }
            else {
                if(!list.isEmpty() && list.getLast() != a[i]){
                    list.add(a[i]);
                }
                i++;
                j++;
            }
        }
        while(i < a.length){
            if(!list.isEmpty() && list.getLast() != a[i]){
                list.add(a[i]);
            }
            i++;
        }

        while(j < b.length){
            if(!list.isEmpty() && list.getLast() != b[j]){
                list.add(b[j]);
            }
            j++;
        }
        list.removeFirst();
        return list;
    }
}
