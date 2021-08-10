package p1021_RemoveOutermostParentheses;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/6/1 13:27
 * <p>
 * A valid parentheses string is either empty (""), "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.
 * For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
 * <p>
 * A valid parentheses string s is primitive if it is nonempty, and there does not exist a way to split it into s = A+B, with A and B nonempty valid parentheses strings.
 * <p>
 * Given a valid parentheses string s, consider its primitive decomposition: s = P_1 + P_2 + ... + P_k, where P_i are primitive valid parentheses strings.
 * <p>
 * Return s after removing the outermost parentheses of every primitive string in the primitive decomposition of S.
 */
class Solution {
    public String removeOuterParentheses(String S) {
        int counter = 0;
        StringBuilder res = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for (char c : S.toCharArray()) {
            if (c == '(') {
                counter++;
            } else {
                counter--;
            }
            temp.append(c);
            if (counter == 0 && temp.length() > 0) {
                res.append(temp.toString(), 1, temp.toString().length() - 1);
                temp = new StringBuilder();
            }
        }
        return res.toString();
    }
}
