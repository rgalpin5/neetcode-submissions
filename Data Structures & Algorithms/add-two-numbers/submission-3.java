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
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        int temp = 0;
        while(l1 != null && l2 != null){
            temp += l1.val + l2.val;
            if(temp >= 10){
                head.next = new ListNode(temp%10);
                temp /= 10;
            }
            else{
                head.next = new ListNode(temp);
                temp = 0;
            }
            head = head.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            temp += l1.val;
             if(temp >= 10){
                head.next = new ListNode(temp%10);
                temp /= 10;
            }
            else{
                head.next = new ListNode(temp);
                temp = 0;
            }
            l1 = l1.next;
            head = head.next;
        }
        while(l2 != null){
            temp += l2.val;
             if(temp >= 10){
                head.next = new ListNode(temp%10);
                temp /= 10;
            }
            else{
                head.next = new ListNode(temp);
                temp = 0;
            }
            l2 = l2.next;
            head = head.next;
        }   
        while(temp > 0) {
            head.next = new ListNode(temp%10);
            head = head.next;
            temp /= 10;
        }
        return dummy.next;
    }
}
