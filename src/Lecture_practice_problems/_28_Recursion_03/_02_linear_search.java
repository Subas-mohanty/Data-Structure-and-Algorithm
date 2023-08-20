package Lecture_practice_problems._28_Recursion_03;

import java.util.ArrayList;

public class _02_linear_search {
    public static void main(String[] args) {
        int [] arr={21,4,87,4,98,56,32};
        int target=4;
//        System.out.println(searchIndexFromLast(arr,target,arr.length-1));
//        searchAllIndex(arr,target,0);
//        System.out.println(list);
//
//        System.out.println(returnAllIndex(arr,target,0,new ArrayList<>()));

        System.out.println(searchAllIndex2(arr,target,0));
    }
    static boolean search(int [] arr, int target, int index){
        // write condition for empty array

        // base condition
        if(index==arr.length){
            return false;
        }
        return arr[index]==target || search(arr,target,index+1);
    }

    static int searchIndex(int [] arr, int target, int index){
        // write condition for empty array

        // base condition
        if(index==arr.length){
            return -1;
        }
        if(arr[index]==target ){
            return index;
        }else{
            return searchIndex(arr,target,index+1);
        }
    }

    static int searchIndexFromLast(int [] arr, int target, int index){
        // write condition for empty array

        // base condition
        if(index==-1){
            return -1;
        }
        if(arr[index]==target ){
            return index;
        }else{
            return searchIndexFromLast(arr,target,index-1);
        }
    }
    static ArrayList<Integer> list=new ArrayList<>();
    static void searchAllIndex(int [] arr, int target, int index){
        // write condition for empty array

        // base condition
        if(index==arr.length){
            return;
        }
        if(arr[index]==target ){
            list.add(index);
        }
        searchAllIndex(arr,target,index+1);
    }

    static ArrayList<Integer> returnAllIndex(int [] arr, int target, int index,ArrayList<Integer> list){
        // write condition for empty array

        // base condition
        if(index==arr.length){
            return list;
        }
        if(arr[index]==target ){
            list.add(index);
        }
        return returnAllIndex(arr,target,index+1,list);
    }


    static ArrayList<Integer> searchAllIndex2(int [] arr, int target, int index){
        // write condition for empty array
        ArrayList<Integer> list=new ArrayList<>();
        // base condition
        if(index==arr.length){
            return list;
        }
        // this will contain answer for that function call only
        if(arr[index]==target ){
            list.add(index);
        }
        ArrayList<Integer> ansFromBelowCalls = searchAllIndex2(arr,target,index+1);
        list.addAll(ansFromBelowCalls);
        return list;
    }
}
