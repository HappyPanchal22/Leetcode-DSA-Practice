/**
 * 101. Symmetric Tree
 * Difficulty: Easy
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(h) where h is height
 * 
 * Tags: Tree, Breadth-First Search, Binary Tree
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
    //RECURSIVE SOLUTION
    public boolean isSymmetric(TreeNode root) {
        // Edge case: empty tree is symmetric
        if(root == null) return true;
        // Check if left and right subtrees are mirrors
        return isMirror(root.left, root.right);
        
    }

    private boolean isMirror(TreeNode left, TreeNode right){
       if(left == null && right == null){
        return true;
       }
       if(left == null || right == null) return false;

       if(left.val != right.val) return false;

    return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }
     
    //Iterative Solution
    /*public boolean isSymmetric(TreeNode root){
        if(root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();

        // Use queue to store pairs of nodes to compare
        queue.offer(root.left);
        queue.offer(root.right);

        while(!queue.isEmpty()){
            // Poll two nodes at a time (a pair)
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if(left == null && right == null) continue;

            if(left == null || right == null) return false;

            if(left.val != right.val) return false;

            queue.offer(left.left);
            queue.offer(right.right);

            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }*/
    
}
