package Leetcode.Array;

import java.util.Arrays;
//https://leetcode.com/problems/boats-to-save-people/description/?envType=daily-question&envId=2024-05-04
public class _881_boats_to_save_people {
    public static void main(String[] args) {
        int[] arr = {3, 1, 1, 1};
        int limit = 3;
        System.out.println(numRescueBoats(arr, limit));
    }

    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int count = 0;
        int i = 0;
        int j = people.length - 1;
        while (i <= j) {
            if (people[i] + people[j] > limit) {
                count++;
                j--;
            }
//            else if( people[i] + people[j] <= limit){
            else {
                i++;
                j--;
                count++;
            }
        }
        return count;
    }
}
