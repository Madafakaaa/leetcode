package p020_ValidParentheses;

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else if (s.charAt(i) == '{') {
                stack.push('{');
            } else if (s.charAt(i) == '[') {
                stack.push('[');
            } else if (s.charAt(i) == ')') {
                if (stack.empty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (pop != '(') {
                    return false;
                }
            } else if (s.charAt(i) == '}') {
                if (stack.empty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (pop != '{') {
                    return false;
                }
            } else if (s.charAt(i) == ']') {
                if (stack.empty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (pop != '[') {
                    return false;
                }
            } else {
                return false;
            }
        }
        return stack.empty();
    }
}
