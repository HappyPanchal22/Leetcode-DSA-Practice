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
        private int[] preorder;
        private int[] inorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
       
       // Build HashMap for O(1) lookup of root in inorder
       inorderMap = new HashMap<>();
       for(int i = 0; i < inorder.length; i++){
        inorderMap.put(inorder[i], i);
       }
       //Build tree recursively
        return helper(0, preorder.length - 1, 0, inorder.length - 1);
    }
    private TreeNode helper(int preStart, int preEnd, int inStart, int inEnd){
        // Base case: invalid range
        if(preStart > preEnd || inStart > inEnd) return null;
        // Step 1: Root is first element in preorder range
        int rootValue = preorder[preStart];
        TreeNode root = new TreeNode(rootValue);
        // Step 2: Find root's index in inorder
        int rootIndex = inorderMap.get(rootValue);
        // Step 3: Calculate left subtree size
        int leftSize = rootIndex - inStart;
        // Step 4: Recursively build left subtree
        root.left = helper(preStart + 1,           // Left starts after root in preorder
                           preStart + leftSize,    // Left ends after leftSize elements
                           inStart,                // Left starts at same place in inorder
                           rootIndex - 1);         // Left ends before root in inorder
         // Step 5: Recursively build right subtree
        root.right = helper(preStart + leftSize + 1,   // Right starts after left subtree
                            preEnd,                    // Right ends at same place
                            rootIndex + 1,             // Right starts after root in inorder
                            inEnd                      // Right ends at same place
                            );
                        
            return root;
    }
}
