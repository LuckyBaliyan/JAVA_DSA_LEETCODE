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
    public boolean isPalindrome(ListNode head) {
        ListNode last = head;
        Stack<Integer> st = new Stack<>(); 

        while(last != null)
        {
            st.add(last.val);
            last = last.next;
        }

        while(head != null && !st.isEmpty()){
            if(head.val != st.pop())return false;
            head = head.next;
        }

        return true;
    }
}