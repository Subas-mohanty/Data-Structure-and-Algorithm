package Leetcode.Array;

// https://leetcode.com/problems/count-number-of-teams/description/

public class _1395_count_no_of_teams {
    // TC : O(n^2)
    // SC : O(1)
    public int numTeams(int[] rating) {
        int n = rating.length;
        int count = 0;
        for(int i = 1; i < n-1; i++){

            // in increasing sequence, left < mid < right
            int leftSmall = leftSmaller(rating, i);
            int rightGreat = rightGreater(rating, i);

            // in decreasing sequence, left > mid > right
            // how we are calcutaing like this, when we know how many elements are greater than or lesser than the curr element are present in left or right we can find its opposite by subtracting this from the total element from right or left
            int rightSmall = n - i - 1 - rightGreat;
            int leftGreat = i - leftSmall;

            // calculating the count for both increasing and decreasing sequence
            count += leftSmall * rightGreat;
            count += leftGreat * rightSmall;
        }
        return count;
    }
    // finding the number of smaller element present to the left of index t
    public int leftSmaller(int [] rating, int t){
        int count = 0;
        for(int i = 0; i < t; i++){
            if(rating[i] < rating[t]) count++;
        }
        return count;
    }

    // finding the number of greater element present to the right of index t
    public int rightGreater(int [] rating, int t){
        int count = 0;
        for(int i = t+1; i < rating.length; i++){
            if(rating[i] > rating[t]) count++;
        }
        return count;
    }
}
