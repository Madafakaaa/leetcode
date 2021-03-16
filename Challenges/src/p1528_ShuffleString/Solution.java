package p1528_ShuffleString;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/3/16 9:27
 */
class Solution {
    public String restoreString(String s, int[] indices) {
        StringBuilder sb = new StringBuilder();
        char[] chars = new char[indices.length];
        for (int i = 0; i < indices.length; i++) {
            chars[indices[i]] = s.charAt(i);
        }
        for (char c : chars) {
            sb.append(c);
        }
        return sb.toString();
    }
}