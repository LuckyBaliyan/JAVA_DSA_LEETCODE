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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null && n == 1){
            head = null;
            return head;
        }

        int size = 0;
        ListNode temp = head;

       

        while(temp != null){
            size++;
            temp = temp.next;
        }

        if(n == size) return head.next;

        int pos = size - n - 1; // stop 1 early 

        ListNode temp2 = head;
        int i = 0;

        while(i <= pos){
            if(i == pos){
                temp2.next = temp2.next.next;
                break;
            }

            temp2 = temp2.next;
            i++;
        }

        return head;
    }
}