package p1614_MaximumNestingDepthOfTheParentheses;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/3/30 17:28
 * <p>
 * A string is a valid parentheses string (denoted VPS) if it meets one of the following:
 * <p>
 * It is an empty string "", or a single character not equal to "(" or ")",
 * It can be written as AB (A concatenated with B), where A and B are VPS's, or
 * It can be written as (A), where A is a VPS.
 * We can similarly define the nesting depth depth(S) of any VPS S as follows:
 * <p>
 * depth("") = 0
 * depth(C) = 0, where C is a string with a single character not equal to "(" or ")".
 * depth(A + B) = max(depth(A), depth(B)), where A and B are VPS's.
 * depth("(" + A + ")") = 1 + depth(A), where A is a VPS.
 * For example, "", "()()", and "()(()())" are VPS's (with nesting depths 0, 1, and 2), and ")(" and "(()" are not VPS's.
 * <p>
 * Given a VPS represented as string s, return the nesting depth of s.
 * <p>
 * Example 1:
 * Input: s = "(1+(2*3)+((8)/4))+1"
 * Output: 3
 * Explanation: Digit 8 is inside of 3 nested parentheses in the string.
 * <p>
 * Example 2:
 * Input: s = "(1)+((2))+(((3)))"
 * Output: 3
 * <p>
 * Example 3:
 * Input: s = "1+(2*3)/(2-1)"
 * Output: 1
 */
class Solution {
    public int maxDepth(String s) {
        int res = 0;
        int leftBracket = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftBracket++;
            }
        }
        return res;
    }
}
