package p1290_ConvertBinaryNumberInLinkedListToInteger;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/3/30 17:05
 * <p>
 * Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.
 * <p>
 * Return the decimal value of the number in the linked list.
 */
class Solution {
    public int getDecimalValue(ListNode head) {
        int result = 0;
        while (head != null) {
            result *= 2;
            result += head.val;
            head = head.next;
        }
        return result;
    }
}
