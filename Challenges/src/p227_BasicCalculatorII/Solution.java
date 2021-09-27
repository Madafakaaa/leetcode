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
    public int calculate(String s) {
        int res = 0;
        int tempValue = 0;
        char sign = '+';
        Stack<Integer> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                continue;
            }
            if (c >= '0' && c <= '9') {
                tempValue = 10 * tempValue + c - '0';
            } else {
                if (sign == '+') {
                    stack.add(tempValue);
                } else if (sign == '-') {
                    stack.add(-tempValue);
                } else if (sign == '*') {
                    stack.add(tempValue * stack.pop());
                } else {
                    stack.add(stack.pop() / tempValue);
                }
                tempValue = 0;
                sign = c;
            }
        }
        if (sign == '+') {
            stack.add(tempValue);
        } else if (sign == '-') {
            stack.add(-tempValue);
        } else if (sign == '*') {
            stack.add(tempValue * stack.pop());
        } else {
            stack.add(stack.pop() / tempValue);
        }
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}
