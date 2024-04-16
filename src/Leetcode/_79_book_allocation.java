package Leetcode;

import java.util.ArrayList;
//https://leetcode.com/problems/split-array-largest-sum/submissions/1234072889/
//https://shorturl.at/rsIM5
public class _79_book_allocation {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(7);
        list.add(2);
        list.add(5);
        list.add(10);
        list.add(8);
        int n = list.size();
        int m = 2;
        System.out.println(findPages(list, n, m));
//        System.out.println(helper(list, 49));
        System.out.println(findPage(list, n, m));
    }
    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        // n is the length of the arrayList and m is the no of students that we need to assign the book
        if(n < m) return -1;
        int sum = 0;
        int maxOfArr = 0;
        for (int i = 0; i < n; i++) {
            sum+= arr.get(i);
            if(arr.get(i) > maxOfArr) maxOfArr = arr.get(i);
        }
        for (int i = maxOfArr; i < sum; i++) {
            int canAllocate = helper(arr, i);
            if(canAllocate == m) return i;
        }
        return -1;
    }

    public static int findPage(ArrayList<Integer> arr, int n, int m){

        int sum = 0;
        int maxOfArr = 0;
        for (int i = 0; i < n; i++) {
            sum+= arr.get(i);
            if(arr.get(i) > maxOfArr) maxOfArr = arr.get(i);
        }

        int ans = -1;
        while(maxOfArr <= sum){
            int mid = maxOfArr + (sum - maxOfArr)/2;
            int noOfStudents = helper(arr, mid);

            // don't know why this is not working
//            if(noOfStudents == m) {
//                ans = mid;
//                sum = mid-1;
//            }

            if(noOfStudents <= m) {
                ans = mid;
                sum = mid-1;
            }
            else maxOfArr = mid+1;
        }
        return ans;
    }
    // this function is to find the number of students, the pages can be assigned
    public static int helper(ArrayList<Integer> arr, int pages){
        int countStudent = 1;
        int sum = 0;
        for (int i = 0; i < arr.size(); i++) {
           if(sum + arr.get(i) <= pages) sum+=arr.get(i);
           else {
               countStudent++;
               sum = arr.get(i);
           }
        }
        return countStudent;
    }
}
