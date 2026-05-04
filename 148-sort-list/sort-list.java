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
        return ms(head);
    }

    public ListNode ms(ListNode head){
        if(head == null || head.next == null)return head;

        ListNode mid = findMid(head);
        ListNode leftHead = head;
        ListNode rightHead = mid.next;
        mid.next = null; //break the connection to seprate the list
        
        leftHead = ms(leftHead);
        rightHead = ms(rightHead);

        return merge(leftHead, rightHead);
    }

    public static ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                temp.next = l1;
                temp = l1;
                l1 = l1.next;
            }
            else{
                temp.next = l2;
                temp = l2;
                l2 = l2.next;
            }
        }

        //fill remaining 
        while(l1 != null){
            temp.next = l1;
            temp = l1;
            l1 = l1.next;
        }

        while(l2 != null){
            temp.next = l2;
            temp = l2;
            l2 = l2.next;
        }

        return dummy.next;
    }
}