package p092_ReverseLinkedListII;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/2/20 9:31
 */
class Solution {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode iterator = dummy;
        for (int i = 1; i < left; i++) {
            iterator = iterator.next;
        }
        ListNode leftPrev = iterator;
        ListNode leftNode = iterator.next;
        ListNode leftNext = iterator.next.next;
        for (int i = 0; i < right - left; i++) {
            iterator = iterator.next;
        }
        ListNode rightPrev = iterator;
        ListNode rightNode = iterator.next;
        ListNode rightNext = iterator.next.next;

        leftPrev.next = null;
        rightPrev.next = null;

        rightNode.next = null;
        leftNode.next = null;

        leftPrev.next = rightNode;
        rightPrev.next = leftNode;

        leftNode.next = rightNext;
        rightNode.next = leftNext;

        return dummy.next;
    }

}
