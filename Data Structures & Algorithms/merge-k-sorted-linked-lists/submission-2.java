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
        int k = lists.length;
        ListNode merged = new ListNode(-1001);
        ListNode temp = merged;
        PriorityQueue<ListNode> mh = new PriorityQueue<>((a,b)->a.val-b.val);
        for (int i=0;i<k;i++){
            mh.add(lists[i]);
        }
        while(!mh.isEmpty()){
            ListNode node = mh.poll();
            temp.next = node;
            temp = node;
            if (node.next != null)
                mh.add(node.next);
        }
        return merged.next;
    }
}
