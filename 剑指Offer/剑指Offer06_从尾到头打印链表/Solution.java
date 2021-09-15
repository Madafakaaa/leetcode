package 剑指Offer.剑指Offer06_从尾到头打印链表;

import java.util.Stack;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/15 1:43
 */
class Solution {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            res[i] = stack.pop();
        }
        return res;
    }
}
