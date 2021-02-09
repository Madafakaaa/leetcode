package p024_SwapNodesInPairs;

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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode temp = dummy;
        while(true){
            if(temp==null||temp.next==null||temp.next.next==null){
                break;
            }
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            ListNode node3 = temp.next.next.next;
            temp.next = node2;
            node2.next = node1;
            node1.next = node3;
            temp = node1;
        }
        return dummy.next;
    }

}