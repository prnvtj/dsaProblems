# Candy

## Problem Information
- **Platform:** Leetcode
- **Difficulty:** Hard
- **URL:** https://leetcode.com/problems/candy/submissions/1897526442/
- **Date:** 2026-01-26

## Solution

```java
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int [] candy = new int [n];
        Arrays.fill(candy, 1);

        for(int i = 1; i < n; i++){
            if(ratings[i] > ratings[i - 1]){
                candy[i] = candy[i-1] + 1;
            }
        }

        for(int i = n - 2; i >=0; i--){
            if(ratings[i] > ratings[i + 1]){
                candy[i] = Math.max(candy[i], candy[i + 1] + 1);
            }
        }
        long total = 0;
        for(int i = 0; i < n; i++){
            total += candy[i];
        }
        return (int)total;
    }
}
```

---
*Generated automatically by LeetFeedback Extension*
