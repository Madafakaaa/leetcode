package p290_WordPattern;

import java.util.HashMap;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/10/20 15:59
 */
class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap map_index = new HashMap();
        String[] words = s.split(" ");

        if (words.length != pattern.length())
            return false;

        for (int i = 0; i < words.length; i++) {
            char c = pattern.charAt(i);
            String w = words[i];

            if (!map_index.containsKey(c))
                map_index.put(c, i);

            if (!map_index.containsKey(w))
                map_index.put(w, i);

            if (map_index.get(c) != map_index.get(w))
                return false;
        }

        return true;
    }
}
