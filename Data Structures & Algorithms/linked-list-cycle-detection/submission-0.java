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
    public boolean hasCycle(ListNode head) {
        ListNode tempNode = head;
        ListNode dummy = new ListNode(0);

        List<ListNode> nodeList = new ArrayList<>();
        while(tempNode.next != null){
            if(nodeList.contains(tempNode.next)){
                return true;
            }
            else{
                nodeList.add(tempNode);
            }
            tempNode = tempNode.next;
        }
        return false;

    }
}
