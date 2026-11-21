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
        ListNode dummy = new ListNode(0, head);
        ListNode endNode = dummy;
        ListNode removeNode = dummy;

        for (int i = 0; i < n; i++) {
            endNode = endNode.next;
        }

        while (endNode.next != null) {
            endNode = endNode.next;
            removeNode = removeNode.next;
        }

        removeNode.next = removeNode.next.next;
        return dummy.next;
    }
}
