/**
 * 104. Maximum Depth of Binary Tree
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
    //Iterative Solution
    /*public int maxDepth(TreeNode root) {
       //Edge Case: empty Tree
       if(root == null) return 0;
       
       //BFS Setup
       Queue<TreeNode> queue = new LinkedList<>();
       queue.offer(root);
       int depth = 0;

       //Process level by level
       while(!queue.isEmpty()){
        int levelSize = queue.size();

        for(int i = 0; i < levelSize; i++){
            TreeNode node = queue.poll();

            //Add Children to queue(next level)
            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
        }
        //Finished one level
        depth++;
       }
      return depth;
    }*/
    //Recursive Solution
    public int maxDepth(TreeNode root) {
        // Base case: empty tree
        if (root == null) {
            return 0;
        }
        
        // Recursive case: calculate left and right depths
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        
        // Current depth = 1 + max of subtrees
        return 1 + Math.max(leftDepth, rightDepth);
    }
}
