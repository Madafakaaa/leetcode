package 剑指Offer.剑指Offer58_翻转单词顺序;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/18 13:58
 */
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int end = s.length() - 1;
        int start = end;
        while (end >= 0) {
            while (end >= 0 && s.charAt(end) == ' ') {
                end--;
            }
            if (end < 0) {
                break;
            }
            start = end;
            while (start >= 0 && s.charAt(start) != ' ') {
                start--;
            }
            sb.append(' ');
            for (int i = start + 1; i <= end; i++) {
                sb.append(s.charAt(i));
            }
            end = start;
        }
        if (sb.length() == 0) {
            return "";
        }
        return sb.toString().substring(1);
    }
}
