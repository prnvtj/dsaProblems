# Number of Substrings Containing All Three Characters

## Problem Information
- **Platform:** Leetcode
- **Difficulty:** Medium
- **URL:** https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/submissions/1888846718/
- **Date:** 2026-01-18

## Solution

```java
class Solution {
    public int numberOfSubstrings(String s) {
        
        int n = s.length();

        int left = 0;
        int [] count = new int [3];
        int ans = 0;
        for(int right = 0; right < n; right++){
            count[s.charAt(right) - 'a']++;
            
            while(count [0] > 0 && count [1] > 0 && count [2] > 0){
                count[s.charAt(left) - 'a']--;
                ans += (n - right);
                left ++;                
            }
        }
        return ans;
    }
}
```

---
*Generated automatically by LeetFeedback Extension*
