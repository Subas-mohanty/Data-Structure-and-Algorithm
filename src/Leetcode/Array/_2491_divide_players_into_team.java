package Leetcode.Array;
import java.util.Arrays;
//https://leetcode.com/problems/divide-players-into-teams-of-equal-skill/?envType=daily-question&envId=2024-10-04


public class _2491_divide_players_into_team {
    // TC : O(n log n + n)
    // SC : O(n) --> internal merge sort

    public long dividePlayers(int[] skill) {

        // As we have to take pair of elements and each team can have only two players, which means after sorting the first and last player should sum up to second and second last and so on, if any pair don't have the equal sum then we can't divide the array into n/2 pairs

        Arrays.sort(skill);

        int s = 0;
        int e = skill.length - 1;
        long sum = 0;
        int check = skill[s] + skill[e];
        while(s < e){
            int first = skill[s] + skill[e];
            if(first != check) return -1;
            sum += skill[s] * skill[e];
            s++;
            e--;
        }
        return sum;
    }
}
