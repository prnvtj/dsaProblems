# Q2. Find the Pivot Integer

## Problem Information
- **Platform:** Leetcode
- **Difficulty:** Easy
- **URL:** https://leetcode.com/problems/find-the-pivot-integer/submissions/1898044409/
- **Date:** 2026-01-26

## Solution

```java
class Solution {
    public int pivotInteger(int n) {
        
        int sq = (n*(n+1))/2;

        return bs(sq);
    }

    public int bs (int sq){
        int lo = 1, hi = sq;

        while(lo <= hi){
            int mid = lo + (hi -lo)/2;

            if(mid*mid == sq) return mid;
            else if(mid*mid < sq) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }
}
```

---
*Generated automatically by LeetFeedback Extension*
