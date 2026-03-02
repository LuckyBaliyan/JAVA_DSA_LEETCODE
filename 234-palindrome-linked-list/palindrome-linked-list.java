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
    public ListNode left;
    public boolean isPalindrome(ListNode head) {
        //left = head;
        //return solve(head);

        Stack<Integer> st = new Stack<>();
        ListNode temp = head;

        while(temp != null){
            st.push(temp.val);
            temp = temp.next;
        }

        ListNode curr = head;

        while(curr != null && !st.isEmpty()){
            if(curr.val != st.pop())return false;

            curr = curr.next;
        }

        return true;
    }

    /*public boolean solve(ListNode right){
        if(right == null)return true;

        if(!solve(right.next))return false;
        if(left.val != right.val)return false;
        
        left = left.next;
        return true;
    }
    */
}