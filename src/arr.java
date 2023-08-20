import java.util.Arrays;

public class arr {
    public static void main(String[] args) {
        int [][] arr={
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}
        };
        int target=7;
        boolean ans=searchMatrix(arr,target);
//        System.out.println(ans);

        int [] num={1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(num));
    }
    public void sortColors(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[j]>nums[j+1]){

                }
            }
        }
    }

    static int maxArea(int[] height) {
        int s=0;
        int e=height.length-1;
        int max=0;
        while(s<e){
            if (s * (e - s) > max) {
                max = s * (e - s);
            }
            s++;
            e--;
        }
        return max;
    }
    static boolean searchMatrix(int[][] matrix, int target) {
        int row=0;
        int col=matrix[0].length-1;
        while(row<=matrix.length-1){
            if(matrix[row][col]>=target){
                return binarySearch(matrix[row],target);
            }
            row++;
        }
        return false;
    }
    static boolean binarySearch(int [] arr,int target){
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==target){
                return true;
            }
            else if(arr[mid]<target){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return false;
    }
}
