package p025_ReverseNodesInKGroup;

import java.util.Stack;

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
    
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0,head);
        ListNode temp = dummy;
        Stack<ListNode> s = new Stack<>();
        while(true){
            ListNode itr = temp;
            for(int i=0;i<k;i++){
                if(itr.next==null) return dummy.next;
                itr=itr.next;
                s.push(itr);
            }
            ListNode end = itr.next;
            itr = temp;
            while(!s.empty()){
                itr.next = s.pop();
                itr = itr.next;
            }
            itr.next = end;
            temp = itr;
        }
    }

}