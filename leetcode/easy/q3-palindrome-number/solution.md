# Q3. Palindrome Number

## Problem Information
- **Platform:** Leetcode
- **Difficulty:** Easy
- **URL:** https://leetcode.com/problems/palindrome-number/submissions/1898046442/
- **Date:** 2026-01-26

## Solution

```java
class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;

        String s = "" + x;

        int lo = 0, hi = s.length() -1;

        while(lo <= hi){
            if(s.charAt(lo++) != s.charAt(hi--)) return false;
        }
        return true;
    }
}
```

---
*Generated automatically by LeetFeedback Extension*
