package Leetcode;

public class _16_FindKthPositive {
    public static void main(String[] args) {
        int [] arr={2,3,4,7,11};
        int k=5;
        int ans=findKthPositive(arr,k);
        System.out.println(ans);
    }
    public static int findKthPositive(int[] arr, int k) {
        int missingNos = 0;
        int ans = 1;
        int index = 0;

        while(index < arr.length && missingNos < k) {
            if(arr[index]==ans) {
                ans++;
                index++;
            }
            else {
                ans++;
                missingNos++;
            }
        }

        while(missingNos < k) {
            ans++;
            missingNos++;
        }
        return ans-1;
    }
}
