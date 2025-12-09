/**
 * 141. Linked List Cycle
 * Difficulty: Easy
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Tags: Linked List, Two Pointers
 */

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        //Floyd's Cycle detection algorithm
        if(head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;    // Moves 1 step
            fast = fast.next.next; // Moves 2 steps

            if(slow == fast) return true;    // if they met cycle is present
        }
        return false;
    }
}
