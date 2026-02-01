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
    public ListNode middleNode(ListNode head) {
        ListNode temp = head;
        int cnt = 0;

        while(temp != null){
            temp = temp.next;
            cnt++;
        }

        ListNode curr = head;
        int n = 0;

        while(curr != null && n < cnt/2){
            curr = curr.next;
            n++;
        }

        return curr;
    }
}