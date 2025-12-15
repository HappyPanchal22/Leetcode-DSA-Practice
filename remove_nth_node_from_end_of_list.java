/**
 * 19. Remove Nth Node From End of List
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
      ListNode dummy = new ListNode(0);
      dummy.next = head;
      ListNode slow = dummy;
      ListNode fast = dummy;

      // Move fast n+1 steps ahead
      for(int i = 0; i <= n; i++){
        fast = fast.next;
      }
      // Move both until fast reaches end
      while(fast != null){
        slow = slow.next;
        fast = fast.next;
      }
      // slow is now at node BEFORE the one to delete
      slow.next = slow.next.next;

      return dummy.next;
    }
}
