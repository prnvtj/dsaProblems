# Minimum Difference Between Highest and Lowest of K Scores

## Problem Information
- **Platform:** Leetcode
- **Difficulty:** Easy
- **URL:** https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/submissions/1896781167/
- **Date:** 2026-01-25

## Solution

```java
class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);

        int i = 0, j = i + k - 1;
        int min = Integer.MAX_VALUE;
        while( j < nums.length){
            min = Math.min(min, (nums[j++] - nums[i++]));
        }
        return min;
    }
}
```

---
*Generated automatically by LeetFeedback Extension*
