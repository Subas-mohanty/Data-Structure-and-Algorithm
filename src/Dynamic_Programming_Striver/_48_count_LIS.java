package Dynamic_Programming_Striver;

import java.util.Arrays;
//https://bit.ly/3fTRGiz
//https://youtu.be/cKVl1TFdNXg?si=P29ztyCm4tP8t-OQ
public class _48_count_LIS {
    public static void main(String[] args) {
        int [] arr= {1,4,3,5,7};
        System.out.println(countLIS(arr));
    }
    public static int countLIS(int [] arr){
        int n = arr.length;
        int [] dp = new int[n];
        int [] count = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[i] > arr[j] && dp[j]+1>dp[i]){
                    dp[i] = dp[j]+1;

                    // when we found an element which is greater than previous element we just inherit the count from the previous element because it is part of it
                    count[i] = count[j];
                }
                // this means we leave an element that's why we get same dp[i]
                // ex -: 1 4 3 5 7
                //  dp = 1 2 2 3 4
                // cnt = 1 1 1 2 2   for 5 count is 2 because when j = 1, dp[i] will be 3 and count will remain same but again when j becomes 2 , dp[i] will be 3 now the count will be count[i] + count[j], if still not understand then watch the video, link is above
                else if(arr[i]>arr[j] && dp[j]+1 == dp[i]) count[i]+=count[j];
            }
            max = Math.max(max, dp[i]);
        }

        // max is the length of LIS , so the index where dp[i] = the LIS we have to find the count element in that index
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if(dp[i] == max) ans+=count[i];
        }
        return ans;
    }
}
