package p722_RemoveComments;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/6 10:50
 */
class Solution {
    public List<String> removeComments(String[] source) {
        StringBuilder sb = new StringBuilder();
        boolean mode = false;
        List<String> res = new ArrayList<>();
        for (String s : source) {
            for (int i = 0; i < s.length(); i++) {
                if (mode) {
                    if (s.charAt(i) == '*' && i + 1 < s.length() && s.charAt(i + 1) == '/') {
                        i++;
                        mode = false;
                    }
                } else {
                    if (s.charAt(i) == '/' && i + 1 < s.length() && s.charAt(i + 1) == '/') {
                        break;
                    } else if (s.charAt(i) == '/' && i + 1 < s.length() && s.charAt(i + 1) == '*') {
                        mode = true;
                        i++;
                    } else {
                        sb.append(s.charAt(i));
                    }
                }
            }
            if (!mode && sb.length() > 0) {
                res.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        return res;

    }
}
