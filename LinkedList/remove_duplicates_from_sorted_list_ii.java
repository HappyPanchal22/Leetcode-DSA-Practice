/**
 * 82. Remove Duplicates from Sorted List II
 * Difficulty: Medium
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Tags: Linked List, Two Pointers
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        while(curr != null){
            // Check if current value is duplicated
            if(curr.next != null && curr.val == curr.next.val){
                // Skip all nodes with this value
                while(curr.next != null && curr.val == curr.next.val){
                curr = curr.next;
            }
            // Skip the last duplicate too
             prev.next = curr.next;
            } else{
                // No duplicate, keep this node
                prev = prev.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}
