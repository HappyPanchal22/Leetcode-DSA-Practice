/**
 * 25. Reverse Nodes in k-Group
 * Difficulty: Hard
 
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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode groupPrev = dummy;
         
        while(true){
            // Check if k nodes remaining
            ListNode kth = getKth(groupPrev, k);
            if(kth == null) break;

            ListNode groupNext = kth.next;

            //Reverse Group
            ListNode prev = kth.next;
            ListNode curr = groupPrev.next;

            while(curr != groupNext){
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            // Connect with previous group
            ListNode tmp = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = tmp;
        }
        return dummy.next;
    }
    private ListNode getKth(ListNode curr, int k){
        while(curr != null && k > 0){
            curr = curr.next;
            k--;
        }
        return curr;
    }
}
