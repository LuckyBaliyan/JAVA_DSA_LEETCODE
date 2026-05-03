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
    public ListNode deleteMiddle(ListNode head) {
        if(head == null)return null;
        if(head.next == null)return null;

        if(head.next.next == null){
            head.next = null;
            return head;
        }

        int size = 0;
        ListNode temp = head;
        while(temp != null){
            temp = temp.next;
            size++;
        }

        int pos = size / 2 - 1;
        int i = 0;

        ListNode temp2 = head;
        while(i < pos){
            temp2 = temp2.next;
            i++;
        }

        temp2.next = temp2.next.next;
        return head;
    }
}