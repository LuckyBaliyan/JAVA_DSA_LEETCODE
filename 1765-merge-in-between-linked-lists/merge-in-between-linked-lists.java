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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode first = list1;
        ListNode last = list1;

        //if(first == null || list2 == null)return list1;

        ListNode tail = list2;
        int curra = 0;
        int currb = 0;

        while(curra < a-1){
            first = first.next;
            curra++;
        }

        while(currb < b+1){
            last = last.next;
            currb++;
        }

        while(tail.next != null)tail = tail.next;


        //lets make new connections
        first.next = list2;
        tail.next = last;

        return list1;
    }
}