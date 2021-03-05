package p002_AddTwoNumbers;

class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int extra = 0;
        ListNode result = new ListNode((l1.val + l2.val) % 10);
        extra = (l1.val + l2.val) / 10;
        ListNode move = result;
        while (l1.next != null && l2.next != null) {
            l1 = l1.next;
            l2 = l2.next;
            ListNode temp = new ListNode((l1.val + l2.val + extra) % 10);
            move.next = temp;
            move = temp;
            extra = (l1.val + l2.val + extra) / 10;
        }
        while (l1.next != null) {
            l1 = l1.next;
            ListNode temp = new ListNode((l1.val + extra) % 10);
            move.next = temp;
            move = temp;
            extra = (l1.val + extra) / 10;
        }
        while (l2.next != null) {
            l2 = l2.next;
            ListNode temp = new ListNode((l2.val + extra) % 10);
            move.next = temp;
            move = temp;
            extra = (l2.val + extra) / 10;
        }
        if (extra == 1) {
            move.next = new ListNode(1);
        }
        return result;
    }

}
