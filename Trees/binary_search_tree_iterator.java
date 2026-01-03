/**
 * 173. Binary Search Tree Iterator
 * Difficulty: Medium
 * 
 * Time Complexity: O(1) average for next(), O(h) for hasNext()
 * Space Complexity: O(h) where h is height
 * 
 * Tags: Tree, Design, Binary Search Tree, Binary Tree, Iterator
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
class BSTIterator {
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushLeft(root);            // Push all left nodes   
    }
    private void pushLeft(TreeNode node){
        while(node != null){
            stack.push(node);
            node = node.left;
        }
    }
    
    public int next() {
        // Pop the top node (it's the next smallest)
        TreeNode node = stack.pop();
        if(node.right != null){
            // If it has right child, push left path of right child
            pushLeft(node.right);
        }
        return node.val;   
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
