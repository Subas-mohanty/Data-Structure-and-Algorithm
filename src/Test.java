public class Test {
    public static void main(String[] args) {
        int [] arr={1,3,5};
        int target=2;
        int ans=searchInsert(arr,target);
        System.out.println(ans);
    }
    static int searchInsert(int[] arr, int target) {
        if (arr.length == 0)
            return -1;
        int start = 0;
        int end = arr.length - 1;
        int mid = 0;
        while (start <= end) {
            // find the middle element
//            int mid=(start+end)/2; // might be possible that (s+e) exceeds the range of int
            mid = start + (end - start) / 2;
            if (target == arr[mid]) {
                return mid;
            } else if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            }
        }
        return end + 1;
    }
}
