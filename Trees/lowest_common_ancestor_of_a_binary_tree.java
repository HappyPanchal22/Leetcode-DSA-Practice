/**
 * 236. Lowest Common Ancestor of a Binary Tree
 * Difficulty: Medium
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(h) where h is height
 * 
 * Tags: Trees
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case 1: reached null
        if(root == null) return null;
        // Base case 2: found one of the target nodes
        if(root == p || root == q ) return root;

        //Recursive Tree Search
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        // Decision logic
        if(left != null && right != null){
            // Found in both sides
            return root;
        }
        if(left !=  null){
            // Found only in left
            return left;
        }
        if(right != null){
            // Found only in right
            return right;
        }
        // Found in neither
        return null;
        
    }
}
