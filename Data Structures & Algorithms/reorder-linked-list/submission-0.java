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
    public ListNode findMiddle(ListNode head) {
    if (head == null)
        return null;

    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }

    return slow; // middle node
}
public ListNode reverse(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;

    while (curr != null) {
        ListNode nextNode = curr.next; // store next
        curr.next = prev;              // reverse link
        prev = curr;                   // move prev
        curr = nextNode;               // move curr
    }

    return prev; // new head
}


    public void reorderList(ListNode head) {
        ListNode middle = findMiddle(head);
        if (middle.next==null)
            return;
        ListNode temp1 = head;
        ListNode temp2 = reverse(middle);
        if (temp1.next==null){
            temp1.next = temp2;
            return;
        }
        ListNode temp3 = temp1.next;
        ListNode temp4 = temp2.next;

        while(temp2.next!=null){
            temp1.next=temp2;
            temp2.next=temp3;
            temp1=temp3;
            temp2 = temp4;
            temp3 = temp1.next;
            temp4= temp2.next;
        }
        
    }
}