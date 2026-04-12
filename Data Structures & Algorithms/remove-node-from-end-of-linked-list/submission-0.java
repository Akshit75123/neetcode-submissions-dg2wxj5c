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
    private void delete(ListNode node){
        node.next=node.next.next;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next==null)
            return null;
        ListNode temp1 = head;
        while(n-->0)
            temp1=temp1.next;
        if (temp1==null)
            return head.next;
        ListNode temp2 = head;
        while(temp1.next!=null){
            temp2 = temp2.next;
            temp1=temp1.next;
        }
        delete(temp2);
        return head;
    }
}
