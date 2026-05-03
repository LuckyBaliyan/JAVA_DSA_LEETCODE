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
    public ListNode oddEvenList(ListNode head) {
        ArrayList<ListNode> odd = new ArrayList<>();
        ArrayList<ListNode> even = new ArrayList<>();

        int turn = 1;
        ListNode temp = head;

        while(temp != null){
            if(turn % 2 == 1)odd.add(temp);
            else even.add(temp);

            temp = temp.next;
            turn++;
        }

        ListNode dummy = new ListNode(-1);
        temp = dummy;

        int sizeOdd = odd.size();
        int sizeEven = even.size();

        int i = 0;

        while(i < sizeOdd){
            temp.next = odd.get(i);
            temp = temp.next;
            i++;
        }

        i = 0;

        while(i < sizeEven){
            temp.next = even.get(i);
            temp = temp.next;
            i++;
        }

        
        temp.next = null; // VERY IMPORTANT
        return dummy.next;
    }
}