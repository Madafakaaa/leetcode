package EvaluateReversePolishNotation;

import java.util.Stack;

class Solution {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (!s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/")) {
                stack.add(Integer.parseInt(s));
            } else {
                int num2 = stack.pop();
                int num1 = stack.pop();
                if (s.equals("+")) {
                    stack.add(num1 + num2);
                } else if (s.equals("-")) {
                    stack.add(num1 - num2);
                } else if (s.equals("*")) {
                    stack.add(num1 * num2);
                } else if (s.equals("/")) {
                    stack.add(num1 / num2);
                }
            }
        }
        return stack.pop();
    }

}