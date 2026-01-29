# Reverse Odd Levels of Binary Tree

## Problem Information
- **Platform:** Leetcode
- **Difficulty:** 1431
- **URL:** https://leetcode.com/problems/reverse-odd-levels-of-binary-tree/submissions/1900536630/
- **Date:** 2026-01-29

## Solution

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        boolean flag = false;
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()){
            int s = q.size();
            ArrayList<TreeNode> al = new ArrayList<>();

            for(int i = 0; i < s; i++){
                TreeNode curr = q.poll();

                if(curr.left != null){
                    q.add((curr.left));
                }
                if(curr.right != null){
                    q.add(curr.right);
                }

                if(flag){
                    al.add(curr);
                }
            }

            if(al.size() > 0){
                int l = 0, r = al.size() - 1;

                while(l < r){
                    int temp = al.get(l).val;
                    al.get(l++).val = al.get(r).val;
                    al.get(r--).val = temp;
                }
            }
            flag = !flag;
        }
        return root;
    }
}
```

---
*Generated automatically by LeetFeedback Extension*
