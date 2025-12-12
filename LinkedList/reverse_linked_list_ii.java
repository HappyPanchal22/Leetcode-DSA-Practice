/**
 * 92. Reverse Linked List II
 * Difficulty: Medium
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Tags: Linked List
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || left == right) return head;
        // Dummy head to handle left = 1 case
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // Step 1: Move to node before 'left'
        for(int i = 1; i < left; i++){
            prev = prev.next;
        }

        ListNode tail = prev.next;
        ListNode curr = tail.next;

        // Step 2: Reverse from 'left' to 'right'
        for(int i = 0; i < right - left; i++){
            // Remove curr from its position
            tail.next = curr.next;
 
            // Insert curr at the start of reversed section
            curr.next = prev.next;
            prev.next = curr;

            // Move curr to next node to reverse
            curr = tail.next;
        }
        return dummy.next;
    }
}
