package p394_DecodeString;

import java.util.Stack;

/**
 * Given an encoded string, return its decoded string.
 * <p>
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 * <p>
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 * <p>
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 * <p>
 * Example 1:
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 * <p>
 * Example 2:
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 * <p>
 * Example 3:
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 * <p>
 * Example 4:
 * Input: s = "abc3[cd]xyz"
 * Output: "abccdcdcdxyz"
 */
class Solution {
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (stack.isEmpty()) {
                if (c >= '0' && c <= '9') {
                    stack.push(c);
                } else {
                    res.append(c);
                }
            } else {
                if (c == ']') {
                    StringBuilder sb = new StringBuilder();
                    while (stack.peek() != '[') {
                        sb.append(stack.pop());
                    }
                    stack.pop();
                    StringBuilder countStr = new StringBuilder();
                    while (!stack.isEmpty() && stack.peek() >= '0' && stack.peek() <= '9') {
                        countStr.append(stack.pop());
                    }
                    countStr = countStr.reverse();
                    Integer count = Integer.parseInt(countStr.toString());
                    String gg = sb.toString();
                    for (int j = 0; j < count - 1; j++) {
                        sb.append(gg);
                    }
                    String newStr = sb.toString();
                    for (int j = newStr.length() - 1; j >= 0; j--) {
                        if (stack.isEmpty()) {
                            res.append(newStr.charAt(j));
                        } else {
                            stack.add(newStr.charAt(j));
                        }
                    }
                } else {
                    stack.push(c);
                }
            }
        }
        return res.toString();
    }
}
