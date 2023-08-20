package Assignment._04_functions;

public class _01_min_max {
    public static void main(String[] args) {
//        int ans=findMax(0,554,78);
        int ans=findMin(0,554,78);
        System.out.println(ans);
    }
    static int findMax(int x,int y,int z){
        int max=0;
        if(x>y){
            max=x;
        }else
            max=y;
        if (z>max) {
            max=z;
        }
        return max;
    }
    static int findMin(int x,int y,int z){
        int min=0;
        if(x<y){
            min=x;
        }else
            min=y;
        if (z<min) {
            min=z;
        }
        return min;
    }
}
