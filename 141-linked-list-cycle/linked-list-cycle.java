/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> st = new HashSet<>();

        ListNode curr = head;
        while(curr != null){
            if(st.contains(curr))return true;

            st.add(curr);
            curr = curr.next;
        }

        return false;
    }
}