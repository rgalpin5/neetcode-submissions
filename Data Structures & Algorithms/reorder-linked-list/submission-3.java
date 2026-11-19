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
        int length = 1;
        ListNode runner = head;
        while(runner.next != null) {
            runner = runner.next;
            length++;
        }
        runner = head;
        ListNode[] arr = new ListNode[length];
        for(int i = 0; i < length; i++) {
            arr[i] = runner; 
            if(runner.next != null) {
                runner = runner.next;
            }
        }

        int left = 0;
        int right = length - 1;
        ListNode writer = new ListNode(0);
        while(left < right) {
            writer.next = arr[left];
            writer = writer.next;
            left++;
            if(left < right) {
                writer.next = arr[right];
                writer = writer.next;
                right--;
            }
        }
        writer.next = arr[left];
        writer.next.next = null;

        
    }
}
