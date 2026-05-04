/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //check whoever have larger length and start that after the diffrence b/w length's steps later

        ListNode temp1 = headA;
        ListNode temp2 = headB;

        int N1 = 0;
        int N2 = 0;

        while(temp1 != null){
            N1++;
            temp1 = temp1.next;
        }

        while(temp2 != null){
            N2++;
            temp2 = temp2.next;
        }

        if(N1 > N2){
            return collisionPoint(headA,headB,N1 - N2);
        }
        else return collisionPoint(headB, headA, N2 - N1);
    }

    public static ListNode collisionPoint(ListNode l1, ListNode l2, int d){
        while(d > 0){
            d--;
            l1 = l1.next;
        }

        while(l1 != l2){
            l1 = l1.next;
            l2 = l2.next;
        }

        return l1;
    }
}