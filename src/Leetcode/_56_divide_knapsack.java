package Leetcode;

// YouTube explanation of Striver
//https://youtu.be/F_DDzYnxO14?si=b5tfS42w7GcWxadn
import java.util.Arrays;
import java.util.Comparator;



public class _56_divide_knapsack {

    double fractionalKnapsack2(int w, Item arr[], int n) {
        double ans = 0;
        // sort in increasing order (value/weight)
        Arrays.sort(arr, (x, y) -> Double.compare((double) y.value / y.weight, (double) x.value / x.weight));
        for(Item it : arr){
            int val = it.value;
            int wt = it.weight;
            if(wt <= w) ans += val;
            else{
                ans += (double)val/wt * w;
                break;
            }
            w -= wt;
        }
        return ans;
    }


    double fractionalKnapsack(int W, Item [] arr, int n) {
//        Arrays.sort(arr, new ItemComparator());

        // we can simply do like this also, we can't simply return y.value/y.weight - x.value/x.weight
        // because it returns a double value but the comparator needs a integer value
        Arrays.sort(arr, (x, y) -> Double.compare((double)y.value/y.weight, (double)x.value/x.weight));
        int count = 0;
        double ans = 0;

        for(int i = 0; i<arr.length; i++){

            // when our count is totally inside the max limit (W) we can take it as whole and the value will also be taken as whole
            if(count + arr[i].weight <= W){
                count += arr[i].weight;
                ans += arr[i].value;
            }
            // now we can't take it as whole so, we have to take fraction of it like this
            else{
                int remain = W - count;
                ans += remain * (double) (arr[i].value / arr[i].weight);
                break;
            }
        }
        return ans;
    }



    // class implementing Comparator to compare objects
    class ItemComparator implements Comparator<Item> {
        public int compare(Item a, Item b){
            double r1 = (double)a.value/(double)a.weight;
            double r2 = (double) b.value / (double) b.weight;

            if(r1 < r2) return 1; // sort in ascending
            else if(r1 > r2) return -1; // sort in descending
            else return 0; // doesn't sort , leave the array as it is
        }
    }


    // Item class given in the question
    class Item {
        int value, weight;
        Item(int x, int y){
            this.value = x;
            this.weight = y;
        }
    }


}
