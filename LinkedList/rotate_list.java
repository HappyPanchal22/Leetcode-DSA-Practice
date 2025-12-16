/**
 * 61. Rotate List
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
    public ListNode rotateRight(ListNode head, int k) {
         // Edge cases
        if(head == null || head.next == null || k == 0) return head;
        //Find length and tail
        int n  = 1;     //length of linked list
        ListNode tail = head;
        while(tail.next != null){
            n++;
            tail = tail.next;
        }

         //Normalize k
        k = k % n;
        if(k == 0) return head;

        //Find new tail (at position length - k - 1)
        ListNode new_tail = head;
        int i = 0;
        while(i < n-k-1){
            new_tail = new_tail.next;
            i++;
        }

        //Get new head
        ListNode new_head = new_tail.next;

        //Reconnect
        tail.next = head;
        new_tail.next = null;

        return new_head;
    }
}
