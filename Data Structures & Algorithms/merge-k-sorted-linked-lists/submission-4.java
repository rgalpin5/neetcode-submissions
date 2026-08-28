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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        ListNode sortedList = null;
        for(int i = 0;i<lists.length;i++){
            sortedList = merge2Lists(sortedList, lists[i]);
        }

        return sortedList;
    }

    private ListNode merge2Lists(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;

        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                dummy.next = l1;
                dummy = dummy.next;
                l1 = l1.next;
            }
            else{
                dummy.next = l2;
                dummy = dummy.next;
                l2 = l2.next;
            }
        }
        if(l2 == null) dummy.next = l1;
        if(l1 == null) dummy.next = l2;

        return head.next;
    }
}
