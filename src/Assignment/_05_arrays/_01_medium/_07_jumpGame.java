package Assignment._05_arrays._01_medium;
public class _07_jumpGame {
    public static void main(String[] args) {
        int [] arr={2,3,1,1,4};
        boolean ans=canJump(arr);
        System.out.println(ans);
        // solve later
    }
    static boolean canJump(int[] nums) {
        int check=0;
        int last=nums.length-1;
        int i=0;
        while(check<=last){
            int value=nums[i];
            check=i+value;
            i+=check;
        }
        if(check==nums.length-1){
            return true;
        }
        else
            return false;
    }
}
