package p025_ReverseNodesInKGroup;

import java.util.ArrayList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1) {
            return head;
        }
        ArrayList<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        for (int i = 0; i < list.size() / k; i++) {
            for (int j = i * k + k - 1; j >= i * k; j--) {
                temp.next = list.get(j);
                temp = temp.next;
            }
        }
        for (int i = (list.size() / k) * k; i < list.size(); i++) {
            temp.next = list.get(i);
            temp = temp.next;
        }
        temp.next = null;
        return dummy.next;
    }

}

/**
 * class Solution {
 * public ListNode reverseKGroup(ListNode head, int k) {
 * if(head==null || head.next==null) return head;
 * <p>
 * ListNode prev=null;
 * ListNode curr=head;
 * ListNode next=null;
 * <p>
 * int h=0;
 * while(curr!=null){
 * h++;
 * curr=curr.next;
 * if(h>=k)
 * break;
 * }
 * curr=head;
 * if(h<k)
 * return head;
 * <p>
 * int i=k;
 * while(curr!=null && i>=1){
 * next=curr.next;
 * curr.next=prev;
 * prev=curr;
 * curr=next;
 * <p>
 * i--;
 * }
 * <p>
 * if(curr!=null){
 * head.next=reverseKGroup(curr,k);
 * }
 * <p>
 * return prev;
 * }
 * }
 */
