package p445_AddTwoNumbersII;

import java.util.Stack;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/6 0:40
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2);
            l2 = l2.next;
        }
        ListNode res = null;
        int extra = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || extra == 1) {
            int temp = (stack1.isEmpty() ? 0 : stack1.pop().val) + (stack2.isEmpty() ? 0 : stack2.pop().val) + extra;
            extra = temp / 10;
            temp = temp % 10;
            ListNode newNode = new ListNode(temp);
            newNode.next = res;
            res = newNode;
        }
        return res;
    }
}
