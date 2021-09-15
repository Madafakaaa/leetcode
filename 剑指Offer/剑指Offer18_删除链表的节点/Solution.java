package 剑指Offer.剑指Offer18_删除链表的节点;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/15 15:51
 */
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode temp = dummy;
        while (temp.next != null && temp.next.val != val) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
        return dummy.next;
    }
}
