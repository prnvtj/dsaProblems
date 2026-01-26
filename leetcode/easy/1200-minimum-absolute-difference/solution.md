# Minimum Absolute Difference

## Problem Information
- **Platform:** Leetcode
- **Difficulty:** Easy
- **URL:** https://leetcode.com/problems/minimum-absolute-difference/submissions/1898018524/
- **Date:** 2026-01-26

## Solution

```java
class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;
        int n = arr.length;
        for(int i = 1; i < n; i++){
            min = Math.min(min, arr[i] - arr[i - 1]);
        }

        for(int i = 1; i < n; i++){
            if(arr[i] - arr[i-1] == min){
                ans.add(new ArrayList<Integer>(Arrays.asList(arr[i - 1], arr[i])));
            }
        }
        return ans;
    }
}
```

---
*Generated automatically by LeetFeedback Extension*
