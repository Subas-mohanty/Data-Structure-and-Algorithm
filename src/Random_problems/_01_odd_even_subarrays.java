package Random_problems;
import java.util.HashMap;
import java.util.Map;

// Question : You are given an integer array, find the no of special sub-arrays in the array, a special sub-array is a sub-array, in which the number of odd and even number element are equal

public class _01_odd_even_subarrays {
    void main() {
        int [] arr = {1,5,8,3,7,6,4,2,1,9};
        System.out.println(findSpecialSubarray(arr));
        System.out.println(findSpecialArrayWithPrefixSum(arr));
    }

    // optimal approach
    // TC : O(n)
    // SC : O(n)
    int findSpecialArrayWithPrefixSum(int [] arr){
        int n = arr.length;
        int cumSum = 0;
        int count = 0;
        // why this prefix array and what is the use of this ?
        // as we are dealing with only odd and even number, lets treat the original array as an array of only -1 and 1
        // we will consider -1 for odd number of +1 for even number
        // ex : array = [1,5,8,3,7,6,4,2,1,9] --> [-1, -1, 1, -1, -1, 1, 1, 1, -1, -1]
        // now if we take the cumulative sum of the new array, that will actually help us find the no of sub-array, but how ?
        // let's take the cumulative sum of the above array
        // [-1, -2, -1, -2, -3, -2, -1, 0, -1, -2]
        // now give attention, we will traverse through this array and for every element we will find how many times this element has occurred previously, that will the no of special sub-array ending at that index
        // but why ?
        // see, for index 2, element = -1, -1 has occurred once previously at index 0, this means, number of odd elements are same at index 0 and 2, so there is a special sub-array between [1,2] same for index 6, there are two special sub-array ending at index 6, one is [1,2] and another is [3,6];
        // and for 0, this itself is a special array, because 0 means no of even and odd are equal (1 and -1 will cancel each other), so in this example, at 0, we will increase the count by 1
        int [] prefix = new int[n];
        for(int i = 0; i < n; i++){
            cumSum += (arr[i] & 1) == 1 ? -1 : 1;
            prefix[i] = cumSum;
        }
        Map<Integer, Integer> map = new HashMap<>();

        for(int a : prefix){
            count += map.getOrDefault(a, 0);
            if(a == 0) count++;
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        return count;
    }

    // brute force, find all sub-arrays having equal number of even and odd digits
    // TC : O(n^2)
    // SC : O(1)
    int findSpecialSubarray(int [] arr){
        int n = arr.length;
        int count = 0;
        for(int i = 0; i < n; i++){
            int even = 0, odd = 0;
            for(int j = i; j < n; j++){
                if((arr[j] & 1) == 1) odd++;
                else even++;

                if(even == odd) {
                    count++;
//                    System.out.println("The subarray is : " + Arrays.toString(Arrays.copyOfRange(arr, i, j + 1)));
                }
            }
        }
        return count;
    }}
