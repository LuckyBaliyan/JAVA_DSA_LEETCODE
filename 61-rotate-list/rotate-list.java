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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0)return head;
        int len = 1;
        ListNode tail = head;

        while(tail.next != null){
            tail = tail.next;
            len++;
        }

        if(k % len == 0)return head;
        k = k % len;

        tail.next = head;

        int pos  = len - k;
        int curr = 1;

        ListNode temp = head;

        while(curr < pos){
           temp = temp.next;
           curr++;
        }

        ListNode newHead = temp.next;
        temp.next = null;

        return newHead;
    }
}