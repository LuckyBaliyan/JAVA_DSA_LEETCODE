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
    public ListNode detectCycle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow){
                slow = head;

                while(slow != fast){
                   slow = slow.next;
                   fast = fast.next; 
                   // why move fast because it's not ncessary that the start point 
                   // is where the cycle detected that can be any point but we have
                   // to find the starting point of cycle

                   // using L = c - x (turotise formula) both needs comman L'steps to 
                   // meet again 
                }

                return slow;
            }
        }

        return null;
    }
}