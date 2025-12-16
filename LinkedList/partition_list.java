/**
 * 86. Partition List
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
    public ListNode partition(ListNode head, int x) {
        //Edge Case
        if(head == null) return null;

        // Create two dummy nodes
        ListNode dummy1 = new ListNode(0);     // for nodes < x
        ListNode dummy2 = new ListNode(0);     // for nodes >= x
        ListNode list1 = dummy1;   //pointer for list1
        ListNode list2 = dummy2;   //pointer for list2
        

        //Traverse and Partition
        ListNode current = head;

        while(current != null){
            if(current.val < x){
                list1.next = current;
                list1 = list1.next;
            }else{
                list2.next = current;
                list2 = list2.next;
            }
            current = current.next;
        }

        //Connect two lists.
        list1.next = dummy2.next;
        list2.next = null;
         return dummy1.next;
        
    }
}
