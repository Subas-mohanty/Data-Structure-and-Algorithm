package Assignment._05_arrays._01_easy;

import java.util.Arrays;

public class _13_flipping_an_image {
    public static void main(String[] args) {
        int [][] arr={
                {1,1,0},
                {1,0,1},
                {0,0,0}

        };
        int [][] ans=flipImage(arr);

        // for printing the 2-D array
        for (int[] a:ans) {
            System.out.println(Arrays.toString(a));
        }
    }
    static int[][] flipImage(int [][] image){
        // every row must be traversed
        for (int i = 0; i < image.length; i++) {
            // for every row , we have to reverse the row'th array
            for (int j = 0; j < (image[i].length+1)/2; j++) {
                int lastElement=(image[i].length)-1-j;
                int temp=image[i][j] ^ 1; // the xor is used to invert the digits if it is 0 then make it 1 or vice versa
                image[i][j]=image[i][lastElement] ^ 1;
                image[i][lastElement]=temp;
            }
        }
        return image;
    }
}
