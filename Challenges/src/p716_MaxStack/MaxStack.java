package p716_MaxStack;

import java.util.Comparator;
import java.util.PriorityQueue;
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

    Stack<Integer> stack;
    Stack<Integer> tempStack;
    PriorityQueue<Integer> priorityQueue;

    /**
     * initialize your data structure here.
     */
    public MaxStack() {
        stack = new Stack<Integer>();
        tempStack = new Stack<Integer>();
        priorityQueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return i2 - i1;
            }
        });
    }

    public void push(int x) {
        stack.add(x);
        priorityQueue.add(x);
    }

    public int pop() {
        Integer res = stack.pop();
        priorityQueue.remove(res);
        return res;
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return priorityQueue.peek();
    }

    public int popMax() {
        Integer res = priorityQueue.poll();
        while (stack.peek().equals(res)) {
            tempStack.add(stack.pop());
        }
        tempStack.add(stack.pop());
        while (!tempStack.isEmpty()) {
            stack.add(tempStack.pop());
        }
        return res;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
