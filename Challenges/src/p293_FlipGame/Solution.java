package p293_FlipGame;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/10/21 14:49
 */
class Solution {
    public List<String> generatePossibleNextMoves(String currentState) {
        List<String> res = new ArrayList<>();
        char[] chars = currentState.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1] == '+' && chars[i] == '+') {
                chars[i] = '-';
                chars[i - 1] = '-';
                res.add(new String(chars));
                chars[i] = '+';
                chars[i - 1] = '+';
            }
        }
        return res;
    }
}
