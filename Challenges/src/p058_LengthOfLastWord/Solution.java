package p058_LengthOfLastWord;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/10/19 17:28
 */
class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                return res;
            }
            res++;
        }
        return res;
    }
}
