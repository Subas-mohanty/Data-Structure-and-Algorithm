```
 int min = (int)Math.pow(10,9);
    for(int i=0; i<=sum/2; i++){
      if(dp[n-1][i]){
        int second = sum-i;
        int minSum = Math.abs(i - second);
        min = Math.min(min, minSum);
      }
    }
    return min;
```
##### this is the extra code that has been added to _15_subsetSum.java
#### So the question is why did we do that ?
#### Here is the explanation why we do that-:

![Explation image](/home/subas/code/Data-Structure-and-Algorithm/src/Notes/DP min subset sum diff.jpg)

