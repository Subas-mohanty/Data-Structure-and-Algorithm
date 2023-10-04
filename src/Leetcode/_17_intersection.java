package Leetcode;
import java.util.Arrays;

//https://leetcode.com/problems/intersection-of-two-arrays/
public class _17_intersection{
    public static void main(String[] args) {
        int [] nums1={8,0,3};
        int [] nums2={0,0};
        int [] ans=intersection(nums1,nums2);
        System.out.println(Arrays.toString(ans));

    }
        public static int[] intersection(int[] nums1, int[] nums2) {
            int length=nums1.length<nums2.length? nums1.length:nums2.length;
            int [] ans=new int [length] ;
            Arrays.fill(ans,-1);
            int i=0;

            int k=0;
            while(i<nums1.length){
                int j=0;
                while(j<nums2.length){
                    if(nums1[i]==nums2[j]){
                        if(notPresent(ans,nums1[i])) {
                            ans[k] = nums1[i];
                            k++;
                        }
                    }
                    j++;
                }
                i++;
            }
            return Arrays.copyOfRange(ans, 0, k);
        }
        public static boolean notPresent(int [] ans, int n){
            for(int i=0;i<ans.length;i++){
                if(ans[i]==n){
                    return false;
                }
            }
            return true;
        }
}
