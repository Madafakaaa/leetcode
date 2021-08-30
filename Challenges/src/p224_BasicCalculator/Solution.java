package p224_BasicCalculator;

import java.util.Stack;

/**
 * Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.
 * <p>
 * Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
 * <p>
 * Example 1:
 * Input: s = "1 + 1"
 * Output: 2
 * Example 2:
 * Input: s = " 2-1 + 2 "
 * Output: 3
 * Example 3:
 * Input: s = "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 */
class Solution {

    public int calculate(String s) {
        if (s == null) return 0;
        int result = 0, sign = 1, currentNum = 0;
        Stack<Integer> signStack = new Stack<>();
        signStack.add(sign);
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                currentNum = 10 * currentNum + c - '0';
            } else if (c == '+' || c == '-') {
                result += sign * currentNum;
                sign = (c == '+' ? 1 : -1) * signStack.peek();
                currentNum = 0;
            } else if (c == '(') {
                signStack.push(sign);
            } else if (c == ')') {
                signStack.pop();
            }
        }
        result += sign * currentNum;
        return result;
    }
}
