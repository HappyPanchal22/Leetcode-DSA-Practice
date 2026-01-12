/**
 * 103. Binary Tree Zigzag Level Order Traversal
 * Difficulty: Medium
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(w) where w is max width
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) return result;
        queue.offer(root);
        boolean leftToRight = true;   // Track direction

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for(int i = 0; i < levelSize; i++){
                  TreeNode node = queue.poll();
                  currentLevel.add(node.val);
                  if(node.left != null) queue.offer(node.left);
                  if(node.right != null) queue.offer(node.right);
            }
            // Reverse if needed
            if(!leftToRight){
                Collections.reverse(currentLevel);
            }
            result.add(currentLevel);

            // Flip direction for next level
            leftToRight = !leftToRight;
        }
        return result;
    }
}
