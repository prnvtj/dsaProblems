# Q1. Can Make Arithmetic Progression From Sequence

## Problem Information
- **Platform:** Leetcode
- **Difficulty:** Easy
- **URL:** https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/submissions/1898028362/
- **Date:** 2026-01-26

## Solution

```java
class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        
        Arrays.sort(arr);
        int n = arr.length;
        int diff = arr[1] - arr[0];

        for(int i = 2; i < n; i++){
            if(arr[i] - arr[i - 1] != diff) return false;
        }
        return true;
    }
}
```

---
*Generated automatically by LeetFeedback Extension*
