/**
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 * Difficulty: Medium
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * 
 * Tags: Trees, Hash Table, Divide and Conquer, Binary Tree
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
        // Build HashMap for O(1) lookup
        inorderMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            inorderMap.put(inorder[i], i);
        }
        return helper(0, postorder.length - 1, 0, inorder.length - 1);
    }
    private TreeNode helper(int postStart, int postEnd, int inStart, int inEnd){
        //Base Case
        if(postStart > postEnd || inStart > inEnd) return null;
         // Root is LAST in postorder 
        int rootValue = postorder[postEnd];
        TreeNode root = new TreeNode(rootValue);
          // Find root in inorder
        int rootIndex = inorderMap.get(rootValue);

        int leftSize = rootIndex - inStart;

        root.left = helper(
            postStart,       // Left starts at same place
            postStart + leftSize - 1,  // Left ends after leftSize elements
            inStart,             
            rootIndex - 1
        );

        root.right = helper(
            postStart + leftSize,  // Right starts after left
            postEnd-1,            // Right ends BEFORE root (postEnd)
            rootIndex + 1,        
            inEnd
        );

        return root;
    }
}
