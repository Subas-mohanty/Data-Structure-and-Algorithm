package Assignment._09_patterns;

public class _03_pattern {
    public static void main(String[] args) {
        pattern(4);
    }
    static void pattern(int n){
        for (int row = 0; row < n; row++) { // this will print the number of rows in the pattern
            // for every row , we have to print the col the required no. of times

//            for (int col = 4-row; col >0 ; col--) {
//                System.out.print("* ");
//            }
            for (int col = 0; col <n-row ; col++) {
                System.out.print("* ");
            }
            System.out.println(); // new line
        }
    }

}
