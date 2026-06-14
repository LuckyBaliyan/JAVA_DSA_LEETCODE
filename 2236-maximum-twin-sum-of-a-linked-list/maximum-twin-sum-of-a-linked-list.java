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
    public int pairSum(ListNode head) {
       // return approach1(head); TC:- O(N) SC:- O(N)
       return approach2(head); //TC:- O(N) SC:- O(1)
    }

    public static int approach1(ListNode head){
          if(head.next.next == null){
            return head.val + head.next.val;
        }
        
        //List to store all the nodes to later directly acess them
        List<ListNode> temp = new ArrayList<>();
        
        //filling the linkedList into liner ds to get in O(1)
        ListNode tempNode =  head;
        while(tempNode != null){
            temp.add(tempNode);
            tempNode = tempNode.next;
        }

        int maxSum = 0;
        int n = temp.size();
        
        //ATQ our range will be utpo mid of the list
        for(int i = 0; i<=((n/2)-1); i++){
            int nextIdx = (n-1-i);
            int sum = temp.get(i).val + temp.get(nextIdx).val;
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

    public static int approach2(ListNode head){
        if(head.next.next == null){
            return head.val + head.next.val;
        }

        ListNode move = head;
        int n = 0;
        while(move != null){
            n++;
            move = move.next;
        }

        ListNode p1 = head;
        ListNode temp = head;

        //move to the starting point of sec half
        for(int i = 0; i < n/2; i++){
            temp = temp.next;
        }

        //reverse the sec half and get its head ref
        ListNode p2 = rev(temp);

        int maxSum = 0;
        
        while(p2 != null){
            maxSum = Math.max(maxSum, p1.val + p2.val);
            p1 = p1.next;
            p2 = p2.next;
        }

        return maxSum;
    }

    public static ListNode rev(ListNode head){
        ListNode prev = null;
        ListNode temp = head;
        ListNode front = head.next;

        while(temp != null){
            front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }

        return prev;
    }
}