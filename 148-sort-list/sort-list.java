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
    public ListNode sortList(ListNode head) {
        PriorityQueue<ListNode> pq = 
        new PriorityQueue<>((a,b)->Integer.compare(a.val, b.val));

        ListNode temp = head;
        while(temp != null){
            pq.offer(temp);
            temp = temp.next;
        }

        ListNode dummy = new ListNode(-1);
        ListNode temp2 = dummy;

        while(!pq.isEmpty()){
            temp2.next = pq.poll();
            temp2 = temp2.next;
        }

        temp2.next = null;
        return dummy.next;
    }
}