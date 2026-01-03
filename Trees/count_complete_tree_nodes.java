/**
 * 222. Count Complete Tree Nodes
 * Difficulty: Medium
 * 
 * Time Complexity: O(log^2 n)
 * Space Complexity: O(log n)
 * 
 * Tags: Binary Search, Tree, Binary Tree
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
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
 
        // Step 1: Calculate left height (always go left)
        int leftHeight = getLeftHeight(root);
        
        // Step 2: Calculate right height (always go right)
        int rightHeight = getRightHeight(root);

        if(leftHeight == rightHeight){
            // Perfect tree: 2^h - 1
             return (1 << leftHeight) - 1;  // 2^h - 1(bit shift)
        }else{
            // Not perfect: recurse
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    } 
         // Helper: Get height going only LEFT
        private int getLeftHeight(TreeNode node){
            int height = 0;
            while(node != null){
            height++;
            node = node.left;
        }
        return height;
    }
    // Helper: Get height going only RIGHT
    private int getRightHeight(TreeNode node){
        int height = 0;
        while(node != null){
            height++;
            node = node.right;
        }
        return height;
    }
}
