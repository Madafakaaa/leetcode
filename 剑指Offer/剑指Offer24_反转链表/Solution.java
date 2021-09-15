package 剑指Offer.剑指Offer24_反转链表;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/15 17:00
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode preNode = null;
        while (current != null) {
            ListNode temp = current.next;
            current.next = preNode;
            preNode = current;
            current = temp;
        }
        return preNode;
    }
}
