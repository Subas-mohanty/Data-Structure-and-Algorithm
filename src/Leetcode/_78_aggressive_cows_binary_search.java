package Leetcode;

import java.util.Arrays;
//https://shorturl.at/diP26

public class _78_aggressive_cows_binary_search {
  public static void main(String[] args) {
    int [] stalls = {0, 3, 4, 7, 10, 9};
    int cows = 4;
    System.out.println(cows(stalls, cows));
//    System.out.println(canPlace(stalls, 1, cows));
    System.out.println(cows2(stalls, cows));
  }

  // TC : O(n*n) --> O(max-min) * O(n)
  // SC : O(1)
  public static int cows(int [] arr, int cows){
    Arrays.sort(arr);
    int n = arr.length;

    // the range is between 1 and arr[last] - arr[first]
    // either we can have distance of 1 between any two cows or distance of arr[last] - arr[first]
    for(int i = 1; i <= arr[n-1]-arr[0]; i++) {
      if (canPlace(arr, i, cows)) continue;
      else return i - 1;
    }
    return -1;
  }

  // TC : O(nlogn)
  // SC : O(1)
  public static int cows2(int [] arr, int cows){
    Arrays.sort(arr);
    int n = arr.length;
    int ans = -1;
    int start = 1;
    int end = arr[n-1] - arr[0];

    while(start <= end){
      int mid = start + (end-start)/2;
      if(canPlace(arr, mid, cows)){
        ans = mid;
        start = mid+1;
      }
      else end = mid -1;
    }
    return ans;
  }

  public static boolean canPlace(int [] arr, int maxDistBetCows, int cows){
    int countCows = 1; // the first cow is placed at the first index of the array
    int last = arr[0]; // this is the position where the last cow is placed, when any new cow will be placed we will update this value, this is where we put the first cow

    for(int i = 1; i < arr.length; i++){
      if(arr[i] - last >= maxDistBetCows){ // if the current element and the element where the last cow was placed means the distance between the cows is greater than the allowed distance(maxDistBetCows) than we can place a new cow there, and we will mark the last placed cow to this index
        countCows++;
        last = arr[i];
      }
      if(countCows >= cows) return true; // if we are able to place more than the number of cows that we need to place than we will return true else false
    }
    return false;
  }
}
