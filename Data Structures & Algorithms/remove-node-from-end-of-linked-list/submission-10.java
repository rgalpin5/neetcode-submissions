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
        if(head.next == null) return null;

        ListNode dummy = new ListNode(0, head);
        ListNode prev = null;
        ListNode curr = head;
        ListNode counter = head;

        int nodes = 0;

        while(counter != null){
            nodes++;
            counter = counter.next;
        }
        if(n == nodes) return head.next;
        int nodeNum = nodes - n + 1;
        int i = 1;
        prev = curr;
        while(curr != null && i < nodeNum) {
            prev = curr;
            curr = curr.next;
            i++;
        }

        if(curr == null || curr.next == null){
            prev.next = null;
            return dummy.next;
        }
        prev.next = curr.next;
        curr.next = null;
        return dummy.next;
    }
}
