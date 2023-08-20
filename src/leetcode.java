public class leetcode {
    public static void main(String[] args) {
//        System.out.println(isUgly(14));
//        System.out.println(1/2);
//        System.out.println(isPowerOfThree(0));
//        System.out.println(Math.sqrt(45)%3);
//        System.out.println(mySqrt(2147395599));

    int [] arr={10,2,2,3}; //24
    int [] ab={3,8,4,5}; // 20
        System.out.println(isWinner(arr,ab));
    }

    static int isWinner(int[] player1, int[] player2) {
        int sum1=0;
        int sum2=0;
        int i=0;
        while(i<player1.length){
            while(i==1 && player1[i-1]==10) {
                player1[i]=player1[i]*2;

            }
            sum1+=player1[i];
            i++;
        }
        int j=0;
        while(j<player2.length){
            while(j==1 && player2[j-1]==10){
                player2[j]=player2[j]*2;
                j++;
            }
            sum2+=player2[j];
        }
        if(sum1>sum2){
            return 1;
        } else if (sum1 == sum2) {
            return 0;
        }
        return 2;
    }
}
