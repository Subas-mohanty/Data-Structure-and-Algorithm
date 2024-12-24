package Lecture_practice_problems_kunal_kushwaha._62_SQRT_algorithm;

public class x {
    public static void main(String[] args) {
        int [] arr = {3,2,4,1,5,7,5,2,3,4,5,6,7};
        int n=arr.length;

        int blockSize=(int)Math.sqrt(n);
        System.out.println(blockSize);

        int [] blockArr= new int[blockSize+1];

        int index=-1;

        // building blocks array
        for(int i=0;i<n;i++){
            if(i%blockSize==0){
                index++;
            }
            blockArr[index]+=arr[i];
        }
        int result = query(arr, blockArr, 2,5);
        System.out.println(result);

    }
    public static int query(int [] arr, int [] blocks, int left, int right){
        int sum =0;

        int n = arr.length;
        int sqrt=(int)Math.sqrt(n);
        // for left
        while(left%sqrt!=0 && left<=right && left != 0){
            sum+=arr[left];
            left++;
        }
        // for middle
        while(left+sqrt<=right){
            sum+=blocks[left/sqrt];
            left+=sqrt;
        }
        // for right
        while(left<=right){
            sum+=arr[left];
            left++;
        }
        return sum;
    }
    public void update(int[] arr, int[] blocks, int index, int value, int sqrt){
        int blockIndex= index/sqrt;
        blocks[blockIndex]=blocks[blockIndex] - arr[index] +value;
        arr[index]=value;
    }
}
