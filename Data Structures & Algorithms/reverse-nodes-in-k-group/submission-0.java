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
        
        if (head == null || k == 1) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode groupPrev = dummy;

        while (true) {
            // 1. Find the k-th node of the current group.
            ListNode kth = groupPrev;
            for (int i = 0; i < k; i++) {
                kth = kth.next;
                // If we reach the end before finding k nodes, we're done.
                if (kth == null) {
                    return dummy.next;
                }
            }
            ListNode nextGroupStart = kth.next;

            // 3. Reverse the current group (from groupPrev.next to kth).
            // The 'prev' pointer starts at the beginning of the *next* group.
            ListNode prev = nextGroupStart; 
            ListNode curr = groupPrev.next;

            while (curr != nextGroupStart) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            
            // 4. Reconnect the linked list.
            // The tail of the now-reversed group is the original head of the group.
            ListNode tailOfReversedGroup = groupPrev.next; 
            
            // Link the previous part of the list to the new head of our group (kth).
            groupPrev.next = kth; 
            
            // The end of our reversed group should now be the new 'groupPrev'
            // for the next iteration.
            groupPrev = tailOfReversedGroup;
        }
        


    }
}
