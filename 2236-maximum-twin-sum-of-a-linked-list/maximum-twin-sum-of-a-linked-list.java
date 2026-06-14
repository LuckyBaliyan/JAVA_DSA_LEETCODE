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
        if(head.next.next == null){
            return head.val + head.next.val;
        }
        
        //List to store all the nodes to later directly acess them
        List<ListNode> temp = new ArrayList<>();

        ListNode tempNode =  head;
        while(tempNode != null){
            temp.add(tempNode);
            tempNode = tempNode.next;
        }

        int maxSum = 0;
        int n = temp.size();

        for(int i = 0; i<=((n/2)-1); i++){
            int nextIdx = (n-1-i);
            int sum = temp.get(i).val + temp.get(nextIdx).val;
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}