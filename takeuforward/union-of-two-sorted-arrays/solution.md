# Union of two sorted arrays

## Problem Information
- **Platform:** Takeuforward
- **Difficulty:** Unknown
- **URL:** https://takeuforward.org/plus/dsa/problems/union-of-two-sorted-arrays
- **Date:** 2026-01-17

## Solution

```java
class Solution {
    public int[] unionArray(int[] nums1, int[] nums2) {
        
        ArrayList<Integer> al = new ArrayList<>();

        int first = 0, n = nums1.length; 
        int second = 0, m = nums2.length;
        int last = 0;
        while(first < n && second < m){
            
            if(nums1[first] < nums2[second]){
                last = nums1[first++];
                al.add(last);
            }else if(nums1[first] > nums2[second]){
                last = nums2[second++];
                al.add(last);
            }else{
                last = nums2[second++];
                al.add(nums1[first++]);
            }

            while(first < n && last == nums1[first]){
                first++;
            }
            while(second < m && last == nums2[second]){
                second++;
            }
        }

        while(first < n){
            last = nums1[first++];
            al.add(last);
            while(first < n && last == nums1[first]){
                first++;
            }
        }
        while(second < m){
            last = nums2[second++];
            al.add(last);
            while(second < m && last == nums2[second]){
                second++;
            }
        }

        int [] ans = new int [al.size()];
        
        for(int i = 0; i < al.size(); i++){
            ans[i] = al.get(i);
        }
        return ans;
    }
}
```

---
*Generated automatically by LeetFeedback Extension*
