package p445_AddTwoNumbersII;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/6 0:40
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode pre1 = new ListNode();
        pre1.next = temp1;
        int extra = 0;
        while (temp1 != null && temp2 != null) {
            temp1.val += temp2.val + extra;
            extra = temp1.val / 10;
            temp1.val %= 10;
            temp1 = temp1.next;
            temp2 = temp2.next;
            pre1 = pre1.next;
        }
        if (temp1 == null) {
            pre1.next = temp2;
            temp1 = temp2;
        }
        while (temp1 != null) {
            temp1.val += extra;
            extra = temp1.val / 10;
            temp1.val %= 10;
            temp1 = temp1.next;
            pre1 = pre1.next;
        }
        if (extra == 1) {
            pre1.next = new ListNode(1);
        }
        return reverse(l1);
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }
}
