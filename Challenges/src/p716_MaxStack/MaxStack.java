package p716_MaxStack;

import java.util.Stack;

/**
 * Design a max stack data structure that supports the stack operations and supports finding the stack's maximum element.
 * <p>
 * Implement the MaxStack class:
 * <p>
 * MaxStack() Initializes the stack object.
 * void push(int x) Pushes element x onto the stack.
 * int pop() Removes the element on top of the stack and returns it.
 * int top() Gets the element on the top of the stack without removing it.
 * int peekMax() Retrieves the maximum element in the stack without removing it.
 * int popMax() Retrieves the maximum element in the stack and removes it. If there is more than one maximum element, only remove the top-most one.
 * <p>
 * Example 1:
 * Input
 * ["MaxStack", "push", "push", "push", "top", "popMax", "top", "peekMax", "pop", "top"]
 * [[], [5], [1], [5], [], [], [], [], [], []]
 * Output
 * [null, null, null, null, 5, 5, 1, 5, 1, 5]
 * Explanation
 * MaxStack stk = new MaxStack();
 * stk.push(5);   // [5] the top of the stack and the maximum number is 5.
 * stk.push(1);   // [5, 1] the top of the stack is 1, but the maximum is 5.
 * stk.push(5);   // [5, 1, 5] the top of the stack is 5, which is also the maximum, because it is the top most one.
 * stk.top();     // return 5, [5, 1, 5] the stack did not change.
 * stk.popMax();  // return 5, [5, 1] the stack is changed now, and the top is different from the max.
 * stk.top();     // return 1, [5, 1] the stack did not change.
 * stk.peekMax(); // return 5, [5, 1] the stack did not change.
 * stk.pop();     // return 1, [5] the top of the stack and the max element is now 5.
 * stk.top();     // return 5, [5] the stack did not change.
 */
class MaxStack {

    private Stack<Integer> stack;
    private Stack<Integer> maxStack;
    private Stack<Integer> buffer;

    /**
     * initialize your data structure here.
     */
    public MaxStack() {
        stack = new Stack<Integer>();
        maxStack = new Stack<Integer>();
        buffer = new Stack<Integer>();
    }

    public void push(int x) {
        stack.push(x);
        if (maxStack.isEmpty() || x >= maxStack.peek()) {
            maxStack.push(x);
        }
    }

    public int pop() {
        Integer res = stack.pop();
        if (res.equals(maxStack.peek())) {
            maxStack.pop();
        }
        return res;
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        Integer res = maxStack.pop();
        while (!stack.peek().equals(res)) {
            buffer.push(stack.pop());
        }
        stack.pop();
        while (!buffer.isEmpty()) {
            int x = buffer.pop();
            if (maxStack.isEmpty() || x >= maxStack.peek()) {
                maxStack.push(x);
            }
            stack.push(x);
        }
        return res;
    }
}























