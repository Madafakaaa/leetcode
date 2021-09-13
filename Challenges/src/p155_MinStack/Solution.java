package p155_MinStack;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/13 20:54
 */
class MinStack {

    PriorityQueue<Integer> heap;
    Stack<Integer> stack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        heap = new PriorityQueue<>();
        stack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        heap.add(val);
    }

    public void pop() {
        Integer res = stack.pop();
        heap.remove(res);
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return heap.peek();
    }
}
