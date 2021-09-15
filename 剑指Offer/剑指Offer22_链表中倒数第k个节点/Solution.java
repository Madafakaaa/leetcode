package 剑指Offer.剑指Offer22_链表中倒数第k个节点;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/15 16:01
 */
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode tail = head;
        for (int i = 1; i < k; i++) {
            tail = tail.next;
        }
        while (tail.next != null) {
            head = head.next;
            tail = tail.next;
        }
        return head;
    }
}
