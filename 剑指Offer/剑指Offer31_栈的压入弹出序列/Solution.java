package 剑指Offer.剑指Offer31_栈的压入弹出序列;

import java.util.Stack;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/15 17:24
 */
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack();
        int i = 0;
        for (int push : pushed) {
            stack.push(push);
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                i++;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
