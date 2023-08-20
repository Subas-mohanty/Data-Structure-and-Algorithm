package Assignment._06_searching._01_easy;

public class _01_square_root_of_a_number {
    public static void main(String[] args) {
        System.out.println(sqRoot(16));
    }
//    static int sqRoot(int num){
//        int start=0;
//        int end=num-1;
//        int temp=0;
//        while (start <= temp) {
//            // find the middle element
////            int mid=(start+end)/2; // might be possible that (s+e) exceeds the range of int
//            int mid=start+(end-start)/2;
//            if ((mid*mid)>end){
//                temp=mid-1;
//            }
//            if((mid*mid)<end){
//                start=mid;
//            }
//            if((mid*mid)==end){
//                return mid;
//            }
//        }
//        return -1;
//    }

    static int sqRoot(int num){
        int result=0;
        for (int i = 0; i <=(num/2); i++) {
            result=i*i;
            if(result<=num){
                return i;
            }
        }
        return -1;
    }
}
