package p796_RotateString;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/20 10:49
 */
class Solution {
    public boolean rotateString(String s, String goal) {
        for (int i = 0; i < s.length(); i++) {
            if (s.equals(goal.substring(i) + goal.substring(0, i))) {
                return true;
            }
        }
        return false;
    }
}
