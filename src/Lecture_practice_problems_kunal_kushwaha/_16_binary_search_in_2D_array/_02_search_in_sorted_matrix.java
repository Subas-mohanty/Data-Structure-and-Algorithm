package Lecture_practice_problems_kunal_kushwaha._16_binary_search_in_2D_array;

import java.util.Arrays;

public class _02_search_in_sorted_matrix {
    public static void main(String[] args) {
        int [][] arr={
                {10,20,30},
                {12,24,32},
                {17,29,35}
        };
        int [] ans=search(arr,29);
        System.out.println(Arrays.toString(ans));
    }
    static int [] binarySearch(int [][] arr,int row,int cStart, int cEnd,int target){
        int mid=cStart+(cEnd-cStart)/2;
        while(cEnd<cStart){
            if(arr[row][mid]==target){
                return new int[]{row,mid};
            }
            else if(arr[row][mid]< target){
                cStart=mid-1;
            }
            else{
                cEnd=mid-1;
            }
        }
        return new int[]{-1,-1};
    }
    static int [] search(int[][] arr,int target){
        int row=arr.length;
        int column=arr[0].length; // be cautious , there might be a possibility that the matrix is empty, it will give null pointer exception

        // if only one row is present, we simply perform binary search on that
        if(row==1){
            return binarySearch(arr,0,0,column-1,target);
        }
        int rStart=0;
        int rEnd=row-1;
        int cMid=column/2;

        // with this while condition we make sure that there are two rows present at least
        while(rStart<(rEnd-1)){
            int mid=rStart+(rEnd-rStart)/2;
            if(arr[mid][cMid]==target){
                 return new int[]{mid,cMid};
            }
            // if the target is greater than the current element then no need to search in the above rows as the matrix is strictly sorted and all the above rows must have elements smaller than the current element
            else if(arr[mid][cMid]<target){
                rStart=mid;
            }
            else{
                rEnd=mid;
            }
        }
        // now we have two rows
        // check whether the target is in the column of two rows
        if (arr[rStart][cMid] == target) {
            return new int[]{rStart,cMid};
        }
        else if(arr[rStart+1][cMid] == target) {
            return new int[]{rStart+1,cMid};
        }

        //search in 1st half
        if(target<=arr[rStart][cMid-1]){
            return binarySearch(arr,rStart,0,cMid-1,target);
        }
        //search in 2nd half
        if(target>=arr[rStart][cMid+1] && target<=arr[rStart][column-1]){
            return binarySearch(arr,rStart,cMid+1,column-1,target);
        }
        //search in 3rd half
        if(target>=arr[rStart+1][cMid-1]){
            return binarySearch(arr,rStart+1,0,cMid-1,target);
        }
        //search in 4th half
        else{
            return binarySearch(arr,rStart+1,cMid+1,column-1,target);
        }
    }
}
