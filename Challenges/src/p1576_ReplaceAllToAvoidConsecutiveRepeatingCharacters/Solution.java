package p1576_ReplaceAllToAvoidConsecutiveRepeatingCharacters;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/3 11:32
 */
class Solution {
    public String modifyString(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '?') {
                char newChar = 'a';
                while ((i != 0 && newChar == chars[i - 1]) || (i != chars.length - 1 && newChar == chars[i + 1])) {
                    newChar++;
                }
                chars[i] = newChar;
            }
        }
        return new String(chars);
    }
}
