package Assignment._09_patterns;

public class _28_pattern {
    public static void main(String[] args) {
        pattern(5);
    }
    static void pattern(int n){
        for (int row = 0; row < 2*n; row++) { // here n is not the no. of row so, we do 2*n
//            *
//            * *
//            * * *
//            * * * *
//            * * *
//            * *
//            *
            int totalColsInRow=row>n?2*n-row:row; // after row no. 4 , row :5 = col:3 ,row :6 = col:2 and so on . That leads to the formula 2*n -row ,i.e, row 5 = 2*4-5 which equals 3 and that is the no of col
            int noOfSpaces=n-totalColsInRow;
            for (int space = 0; space < noOfSpaces; space++) {
                System.out.print(" ");
            }
            for (int col = 0; col < totalColsInRow; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
