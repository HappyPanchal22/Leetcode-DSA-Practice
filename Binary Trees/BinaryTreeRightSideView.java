/**
 * 199. Binary Tree Right Side View
 * Difficulty: Medium
 * * Time Complexity: O(n)
 * Space Complexity: O(h) - where h is the height of the tree (recursion stack)
 * * Tags: Tree, Depth-First Search, Breadth-First Search, Binary Tree
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }
    private void dfs(TreeNode node, int depth, List<Integer>result){
        if(node == null) return;
        
        // First time at this depth? Add to result
        if(depth == result.size()){
            result.add(node.val);
        }
        
        // Visit right BEFORE left (important!)
        dfs(node.right, depth + 1, result);
        dfs(node.left, depth + 1, result);

    }
}
