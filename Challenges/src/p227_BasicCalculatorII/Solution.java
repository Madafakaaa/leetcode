package p227_BasicCalculatorII;

import java.util.Stack;

/**
 * Given a string s which represents an expression, evaluate this expression and return its value.
 * <p>
 * The integer division should truncate toward zero.
 * <p>
 * You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].
 * <p>
 * Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
 * <p>
 * Example 1:
 * Input: s = "3+2*2"
 * Output: 7
 * Example 2:
 * Input: s = " 3/2 "
 * Output: 1
 * Example 3:
 * Input: s = " 3+5 / 2 "
 * Output: 5
 */
class Solution {

    Stack<Integer> stack;
    char operation;
    Integer tempValue;

    public int calculate(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        stack = new Stack<>();
        operation = '+';
        tempValue = 0;
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                continue;
            }
            if (Character.isDigit(c)) {
                tempValue = tempValue * 10 + c - '0';
            } else {
                update();
                operation = c;
                tempValue = 0;
            }
        }
        update();
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    public void update() {
        if (operation == '+') {
            stack.add(tempValue);
        } else if (operation == '-') {
            stack.add(-tempValue);
        } else if (operation == '*') {
            stack.add(stack.pop() * tempValue);
        } else {
            stack.add(stack.pop() / tempValue);
        }
    }
}
