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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        ListNode l1 = list1;
        ListNode l2 = list2;

        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                curr.next = l1;
                l1 = l1.next;
            }
            else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        //if any of them left
        while(l1 != null){
            curr.next = l1;
            l1 = l1.next;
            curr = curr.next;
        }

        while(l2 != null){
            curr.next = l2;
            l2 = l2.next;
            curr = curr.next;
        }

        return dummy.next;
    }
}