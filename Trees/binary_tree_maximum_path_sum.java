/**
 * 124. Binary Tree Maximum Path Sum
 * Difficulty: Hard
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(h) where h is height
 * 
 * Tags: Dynamic Programming, Tree, Binary Tree
 */

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
    private int globalMax;   // Track the global maximum

    public int maxPathSum(TreeNode root) {
        globalMax = Integer.MIN_VALUE;  //nodes can be negative!
        helper(root);
        return globalMax;
    }
    private int helper(TreeNode node){
        //Base Case
        if(node == null) return 0;
        // Step 1: Get max path sum from left child
        // (ignore if negative)
        int leftMax = Math.max(helper(node.left),0);
        // Step 2: Get max path sum from right child
        // (ignore if negative)
        int rightMax = Math.max(helper(node.right),0);
         // Step 3: Calculate path that "turns" at this node
        // (Uses BOTH children)
        int paththroughNode = node.val + leftMax + rightMax;
         // Step 4: Update global maximum
        globalMax = Math.max(globalMax, paththroughNode);
        // Step 5: Return max path going DOWN from this node
         return node.val + Math.max(leftMax, rightMax);
    }
}
