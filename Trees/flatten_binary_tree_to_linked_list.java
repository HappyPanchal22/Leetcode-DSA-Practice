/**
 * 114. Flatten Binary Tree to Linked List
 * Difficulty: Medium
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Tags: Linked List, Stack, Tree
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
    public void flatten(TreeNode root) {
        TreeNode current = root;

        while(current != null){
             // If current has left child
            if(current.left != null){
                // Step 1: Find rightmost node in left subtree
                TreeNode rightmost = current.left;

                while(rightmost.right != null){
                    rightmost = rightmost.right;
                }
                // Step 2: Connect rightmost to current's right
                rightmost.right = current.right;

                // Step 3: Move left to right
                current.right = current.left;
                current.left = null;
            }
            current = current.right;
        }

    }
}
