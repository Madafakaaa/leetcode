package MinStack;

import java.util.PriorityQueue;
import java.util.Stack;

class MinStack {

    PriorityQueue<Integer> queue;
    Stack<Integer> stack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        queue = new PriorityQueue<Integer>();
        stack = new Stack<Integer>();
    }

    public void push(int x) {
        queue.add(x);
        stack.add(x);
    }

    public void pop() {
        Integer i = stack.pop();
        queue.remove(i);
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return queue.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */