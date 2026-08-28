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

        
        for(int i = 1; i < lists.length; i++){
            lists[i] = merge2Lists(lists[i], lists[i - 1]);
        }

        return lists[lists.length - 1];
    }

    private ListNode merge2Lists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode dummy = head;

        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                dummy.next = list1;
                list1 = list1.next;
            }
            else{
                dummy.next = list2;
                list2 = list2.next;
            }
            dummy = dummy.next;
        }
        if(list1 != null){
            dummy.next = list1;
        }
        else{
            dummy.next = list2;
        }
        return head.next;
    }
}
