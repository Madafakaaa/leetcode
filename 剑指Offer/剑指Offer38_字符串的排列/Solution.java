package 剑指Offer.剑指Offer38_字符串的排列;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/17 15:45
 */
class Solution {

    ArrayList<String> res;
    char[] chars;
    boolean[] used;

    public String[] permutation(String s) {
        if (s.isEmpty()) {
            return new String[0];
        }
        res = new ArrayList<String>();
        chars = s.toCharArray();
        used = new boolean[chars.length];
        Arrays.sort(chars);
        backtrack(new StringBuilder(), 0);
        String[] resArray = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resArray[i] = res.get(i);
        }
        return resArray;
    }

    public void backtrack(StringBuilder sb, int count) {
        if (count == chars.length) {
            res.add(sb.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (used[i] || (i > 0 && chars[i] == chars[i - 1] && used[i - 1])) {
                continue;
            }
            sb.append(chars[i]);
            used[i] = true;
            backtrack(sb, count + 1);
            used[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}





















