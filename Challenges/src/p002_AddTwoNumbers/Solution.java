package p002_AddTwoNumbers;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example 1:
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * <p>
 * Example 2:
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * <p>
 * Example 3:
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 */
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





























