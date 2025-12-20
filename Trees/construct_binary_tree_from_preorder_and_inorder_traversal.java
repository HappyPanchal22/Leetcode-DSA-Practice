/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * Difficulty: Medium
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * 
 * Tags: Array, Divide and Conquer, Tree Binary Tree
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
    private HashMap<Integer, Integer> inorderMap;
    private int[] postorder;
    private int[] inorder;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;

        inorderMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            inorderMap.put(inorder[i], i);
        }
        return helper(0, postorder.length - 1, 0, inorder.length - 1);
    }
    private TreeNode helper(int postStart, int postEnd, int inStart, int inEnd){
        //Base Case
        if(postStart > postEnd || inStart > inEnd) return null;

        int rootValue = postorder[postEnd];
        TreeNode root = new TreeNode(rootValue);

        int rootIndex = inorderMap.get(rootValue);

        int leftSize = rootIndex - inStart;

        root.left = helper(
            postStart,
            postStart + leftSize - 1,
            inStart,
            rootIndex - 1
        );

        root.right = helper(
            postStart + leftSize,
            postEnd-1,
            rootIndex + 1,
            inEnd
        );

        return root;
    }
}
