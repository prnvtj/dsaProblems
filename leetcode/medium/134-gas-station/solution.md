# Gas Station

## Problem Information
- **Platform:** Leetcode
- **Difficulty:** Medium
- **URL:** https://leetcode.com/problems/gas-station/submissions/1897443813/
- **Date:** 2026-01-26

## Solution

```java
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalGas = 0;
        int currGas = 0;
        int start = 0;

        for(int i = 0; i < n; i++){
            totalGas += (gas[i] - cost[i]);
            currGas += (gas[i] - cost[i]);

            if(currGas <0) {
                currGas = 0;
                start = i + 1;
            }
        }

        if(totalGas < 0) return -1;
        return start;
    }
}
```

---
*Generated automatically by LeetFeedback Extension*
