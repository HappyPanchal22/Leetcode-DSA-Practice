/**
 * 637. Average of Levels in Binary Tree
 * Difficulty: Easy
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(w) where w is max width
 * 
 * Tags: Tree, Depth-First Search, Breadth-First Search, Binary Tree
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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            double sum = 0;     // Use double to avoid overflow

            for(int i = 0; i < levelSize; i++){
                TreeNode node = queue.poll();
                // Add to sum
                sum += node.val;

                // Add children for next level
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            // Calculate average for this level
            double average = sum / levelSize;

            result.add(average);
        }
        return result;
    }
}
