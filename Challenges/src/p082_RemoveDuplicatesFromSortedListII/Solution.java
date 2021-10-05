package p082_RemoveDuplicatesFromSortedListII;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/10/4 23:31
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode temp = dummy;
        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                temp.next = head.next;
            } else {
                temp = temp.next;
            }

            head = head.next;
        }
        return dummy.next;
    }
}
