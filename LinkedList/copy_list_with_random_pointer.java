/**
 * 138. Copy List with Random Pointer
 * Difficulty: Medium
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)(excluding result)
 * 
 * Tags: Linked List
 */

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return  null;
        Node current = head;

       //Step 1: Create copies of nodes and interweave into the original linkedlist

        while(current != null){
            Node copy = new Node(current.val);
            copy.next = current.next;
            current.next = copy;
            current = copy.next;
        } 
        //Step 2: Set random pointers of new copied nodes;
        current = head;
        while(current != null){
            if(current.random != null){
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }
       //Step 3: Separate the two lists
       Node dummy = new Node(0);
       Node copycurrent = dummy;
       current = head;
       while(current != null){
        copycurrent.next = current.next;
        current.next = current.next.next;

        current = current.next;
        copycurrent = copycurrent.next;
       }
        return dummy.next;
    }
}
