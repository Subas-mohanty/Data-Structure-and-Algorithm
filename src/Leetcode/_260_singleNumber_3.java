package Leetcode;
//https://leetcode.com/problems/single-number-iii/description/?envType=daily-question&envId=2024-05-31
public class _260_singleNumber_3 {
    public int[] singleNumber(int[] arr) {
        int xorans=0;
        for (int i = 0; i < arr.length; i++) {
            xorans^=arr[i]; // This will leave with XOR of the two distinct element
        }
        // Now we have to separate the xor to get the answer
        // for that we have to find the first setbit of the XOR
        // for that there is a formula i.e, x & ~(x-1)
        // why is this happening and what is it doing
        // let's break this down at the bottom of this problem

        xorans=xorans & ~(xorans-1); // now we got the first setbit of the XOR ans

        int set1=0; // number with setbit as one will be stored in this, then by performing XOR with all elements we get the unique element in that set
        int set2=0; // number with setbit as zero will be stored in this, then by performing XOR with all elements we get the unique element in that set

        for (int i = 0; i < arr.length; i++) {
            if ((xorans & arr[i]) != 0) {
                set1^=arr[i];
            } else{
                set2^=arr[i];
            }
        }
        return new int[]{set1,set2};
    }
}


/*
   xorans=xorans & ~(xorans-1)
   this thing is making sure that it gives a number which has only the rightmost set bit or xorans as 1 and all other bits as 0
   ex - if xorans = 6, where the right most bit = 1 so it will give the number like 010

   let's take another example
   ex xorans = 20
   20 = 10110
   19 = 10101
   observe one thing that all the bits before the rightmost set bit remains same and bits after the rightmost set bit including that bit is flipped
   so when we do a negation , the left part will be reversed, performing & will give 0 and the right part will be same as the right part of the original number
   and we know that the right part starts from the rightmost set bit so it has a single 1, that's why it will return a number which will have 1 set bit as the original numbers set bit place and all other bits will be 0



   now we can create two bucket set to check which number has this bit as 0 or 1 and we can make two separate sets, and it will make sure that the two distinct number will be in two different buckets
 */