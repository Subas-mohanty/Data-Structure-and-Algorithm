package Programming_Concepts;

class Main{
    void main(){
        int [] arr = {1,2,3,4,5,5};
        int left = 0;
        int right = arr.length - 1;
        FenwickTree fenwickTree = new FenwickTree(arr.length);
        for(int i = 0; i < arr.length; i++) fenwickTree.update(i, arr[i]);
        System.out.println(fenwickTree.findSum(left, right));
    }
}

//https://www.youtube.com/watch?v=9uaXG62Y8Uw
// update time : O(log n)
// query time : O(log n)
public class FenwickTree {
    private final int [] fenwick;
    int size;

    public FenwickTree(int n){
        this.fenwick = new int[n + 1]; // make it 1 based indexing because 0 based indexing will not work while updating the indices
        this.size = n + 1;
    }

    // time : O(log n)
    public void update(int ind, int val){
        ind = ind + 1;
        while(ind < size){
            fenwick[ind] += val;
            // for the next index, take ind AND 2's complement of ind and then add it with original value of ind
            ind = ind + (ind & -ind);
        }
    }
    // time : O(log n)
    public int findSum(int left, int right){
        // (sum till right) - (sum till left - 1)
        return findSum(right) - findSum(left - 1);
    }
    private int findSum(int ind){
        int sum = 0;
        ind++; // converting to 1 based indexing
        while(ind > 0){
            sum += fenwick[ind];
            // index update, (make the LSB to 0 of ind)
            ind = ind - (ind & -ind);
        }
        return sum;
    }
}
