# Number of Valid Clock Times

## Problem Information
- **Platform:** Leetcode
- **Difficulty:** 1426
- **URL:** https://leetcode.com/problems/number-of-valid-clock-times/submissions/1900221533/
- **Date:** 2026-01-28

## Solution

```java
class Solution {
    public int countTime(String time) {
        
        String times [] = time.split(":");
        String hour = times[0];
        String min = times[1];

        int ch = 0;
        int cm = 0;
        char d1 = hour.charAt(0);
        char d2 = hour.charAt(1);
        char d3 = min.charAt(0);
        char d4 = min.charAt(1);
        if(d1 == '?' && d2 == '?'){
            ch = 24;
        }else if (d1 == '?'){
            ch = (d2 > '3')? 2: 3;
        }else if(d2 == '?'){
            ch = (d1 < '2')? 10: 4;
        }else{
            ch = 1;
        }
        if(d3 == '?' && d4 == '?'){
            cm = 60;
        }else if (d3 == '?'){
            cm = 6;
        }else if(d4 == '?'){
            cm = 10;
        }else{
            cm = 1;
        }

        return cm*ch;
    }
}
```

---
*Generated automatically by LeetFeedback Extension*
