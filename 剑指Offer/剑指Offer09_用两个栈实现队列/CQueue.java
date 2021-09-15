package 剑指Offer.剑指Offer09_用两个栈实现队列;

import java.util.Stack;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/15 14:02
 */
class CQueue {

    Stack<Integer> stack;
    Stack<Integer> buffer;

    public CQueue() {
        stack = new Stack<>();
        buffer = new Stack<>();
    }

    public void appendTail(int value) {
        stack.add(value);
    }

    public int deleteHead() {
        if (!buffer.isEmpty()) {
            return buffer.pop();
        }
        if (stack.isEmpty()) {
            return -1;
        }
        while (!stack.isEmpty()) {
            buffer.add(stack.pop());
        }
        return buffer.pop();
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */






