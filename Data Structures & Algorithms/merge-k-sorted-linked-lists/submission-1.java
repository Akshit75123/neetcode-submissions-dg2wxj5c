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
        int n = lists.length;
        ListNode merged = new ListNode(-1001);
        for (int i=0;i<n;i++){
            merged = merge(merged,lists[i]);
        }
        return merged.next;
    }
    public ListNode merge(ListNode l1,ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        ListNode t1=l1, t2=l2;
        while(t1!=null && t2!=null){
            if (t1.val<t2.val){
                temp.next = t1;
                temp = t1;
                t1=t1.next;
            }
            else {
                temp.next = t2;
                temp=t2;
                t2=t2.next;
            }
        }
        if (t1!=null)
            temp.next = t1;
        if (t2!=null)
            temp.next = t2;
        return dummy.next;
    }
}
