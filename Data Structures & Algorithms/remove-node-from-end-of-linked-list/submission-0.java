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
        ListNode traverse = head;
        int size = 0;
        while(traverse != null){
            size++;
            traverse = traverse.next;
        }

        int target = size - n;

        if(target == 0) return dummy.next.next;

        ListNode replace = head;
        ListNode prev = dummy;
        while(target>0){
            prev = prev.next;
            replace = replace.next;
            target--;
        }
        prev.next = replace.next;

        return dummy.next;
    }
}
