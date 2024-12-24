package Leetcode.Array;
//https://leetcode.com/problems/median-of-two-sorted-arrays/
public class _04_median_of_two_sorted_array {
    public static void main(String[] args) {
        int [] nums1 = {1, 3};
        int [] nums2 = {2};
        System.out.println(findMedianSortedArrays(nums1, nums2));
        System.out.println(function(nums1, nums2));
    }
    public static double function(int[] nums1, int[] nums2){
        int n1 = nums1.length;
        int n2 = nums2.length;
        int i = 0;
        int j = 0;
        int n = (n1+n2);
        int ind2 = n/2;
        int ind1 = ind2-1;
        int cnt = 0;
        int ind1el = -1;
        int ind2el = -1;

        while(i < n1 && j < n2){
            if(nums1[i] < nums2[j]){
                if(cnt == ind1) ind1el = nums1[i];
                if(cnt == ind2) ind2el = nums1[i];
                i++;
            }
            else{
                if(cnt == ind1) ind1el = nums2[j];
                if(cnt == ind2) ind2el = nums2[j];
                j++;
            }
            cnt++;

            // if we have found both ind1el and ind2el then no need to go further
            if(ind1el != -1 && ind2el != -1) break;
        }
        while(i < n1){
            if(cnt == ind1) ind1el = nums1[i];
            if(cnt == ind2) ind2el = nums1[i];
            cnt++;
            i++;
            if(ind1el != -1 && ind2el != -1) break;
        }
        while(j < n2){
            if(cnt == ind1) ind1el = nums2[j];
            if(cnt == ind2) ind2el = nums2[j];
            cnt++;
            j++;
            if(ind1el != -1 && ind2el != -1) break;
        }
        if(n % 2 == 0) return (double) ((ind1el+ind2el)/2);
        return (double) ind2el;
    }
    // TC : O(m+n) because we are traversing all the elements of nums1 and nums2
    // SC : O(m+n) for the ans array
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int [] ans=new int[nums1.length+nums2.length];
        ans=merge(nums1,nums2);
        int mid=(ans.length-1)/2;
        if(ans.length%2==0){
            return (double)(ans[mid]+ans[mid+1])/2;
        }
        return (double)ans[mid];
    }
    public static int [] merge(int [] nums1, int [] nums2){
        int i,j,k;
        i=j=k=0;
        int [] nums=new int[nums1.length+nums2.length];
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<nums2[j]){
                nums[k]=nums1[i];
                i++;
            }
            else{
                nums[k]=nums2[j];
                j++;
            }
            k++;
        }
        while(i<nums1.length){
            nums[k]=nums1[i];
            i++;
            k++;
        }
        while(j<nums2.length){
            nums[k]=nums2[j];
            j++;
            k++;
        }
        return nums;
    }
}
