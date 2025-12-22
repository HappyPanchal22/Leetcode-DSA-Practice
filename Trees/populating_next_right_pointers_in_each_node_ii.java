/**
 * 117. Populating Next Right Pointers in Each Node II
 * Difficulty: Medium
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Tags: Linked List, Tree, Binary Tree
 * Date Solved: 2024-12-15
 */

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
           // Leftmost node of current level
        Node leftmost = root;

        while(leftmost != null){
            // Traverse current level using next pointers
            Node current = leftmost;

            // Dummy node to help build next level's connections
            Node dummy = new Node(0);
            Node tail = dummy;
            // Traverse current level
            while(current != null){
                //Connect left child
                if(current.left != null){
                    tail.next = current.left;
                    tail = tail.next;
                }
                //Connect right child
                if(current.right != null){
                    tail.next = current.right;
                    tail = tail.next;
                }
                current = current.next;
            }
            // Move to next level's leftmost
            leftmost = dummy.next;
        }
        return root;
    }
}
