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
    public void reorderList(ListNode head) {
        if(head.next == null) return;
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        while(fast != null && fast.next != null) {
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        prev.next = null;
        ListNode curr = slow;
        prev = null;

        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        //H2->4-> C8->P6->null
       
        ListNode dummy = head;

        while(prev != null && dummy != null) {
            ListNode temp1 = dummy.next;
            ListNode temp2 = prev.next;
            dummy.next = prev;
            dummy = dummy.next;
            dummy.next = temp1;
            if(dummy.next != null) dummy = dummy.next;
            prev = temp2;
        }

        if(prev != null) dummy.next = prev;


    }
}
