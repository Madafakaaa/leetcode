package p161_OneEditDistance;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/15 0:17
 */
class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (s.length() > t.length()) {
            return isOneEditDistance(t, s);
        }
        if (t.length() - s.length() > 1) {
            return false;
        }
        if (t.length() == s.length()) {
            for (int i = 0; i < s.length(); i++) {
                if (t.charAt(i) != s.charAt(i)) {
                    return t.substring(i + 1).equals(s.substring(i + 1));
                }
            }
            return false;
        } else {
            for (int i = 0; i < s.length(); i++) {
                if (t.charAt(i) != s.charAt(i)) {
                    return t.substring(i + 1).equals(s.substring(1));
                }
            }
            return true;
        }
    }
}
