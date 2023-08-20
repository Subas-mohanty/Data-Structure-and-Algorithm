import java.util.Arrays;

public class find {
    public static void main(String[] args) {
        int [] arr={1,2,3,1,2,3};
        boolean ans=containsNearbyDuplicate(arr,2);
        System.out.println(ans);
    }
    static boolean containsNearbyDuplicate(int[] nums, int k) {
        for(int i=0;i<nums.length;i++){
            for(int j=1;j<nums.length;j++){
                if(nums[i]==nums[j] && i!=j){
                    if(Math.abs(i-j)<=k){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
