package p093_RestoreIPAddresses;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/14 1:16
 */
class Solution {


    ArrayList<String> res;
    String s;

    public List<String> restoreIpAddresses(String s) {
        res = new ArrayList<>();
        this.s = s;
        helper(new StringBuilder(), 0, 0);
        return res;
    }

    public void helper(StringBuilder sb, int start, int count) {
        if (count >= 4) {
            if (start == s.length()) {
                res.add(sb.toString().substring(0, sb.length() - 1));
            }
            return;
        }
        for (int i = start; i < s.length(); i++) {
            String str = s.substring(start, i + 1);
            if (str.length() > 1 && str.charAt(0) == '0') {
                return;
            }
            Integer value = Integer.parseInt(str);
            if (value > 255) {
                return;
            }
            // backtrack;
            sb.append(str + ".");
            helper(sb, i + 1, count+1);
            sb.delete(sb.length() - str.length() - 1, sb.length());
        }
    }
}






















