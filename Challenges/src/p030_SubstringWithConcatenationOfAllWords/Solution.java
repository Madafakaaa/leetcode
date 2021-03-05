package p030_SubstringWithConcatenationOfAllWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() < 1 || words == null || words.length < 1) {
            return res;
        }
        Map<String, Integer> wordsMap = new HashMap<>();
        for (String str : words) {
            wordsMap.put(str, wordsMap.getOrDefault(str, 0) + 1);
        }
        int oneLen = words[0].length();
        int wordsLen = words.length * oneLen;
        for (int i = 0; i < oneLen; i++) {
            Map<String, Integer> subMap = new HashMap<>();
            int l = i, r = i;
            int count = 0;
            for (r = i; r + oneLen <= s.length(); r += oneLen) {
                String rword = s.substring(r, r + oneLen);
                if (!wordsMap.containsKey(rword)) {
                    l = r + oneLen;
                    count = 0;
                    subMap.clear();
                } else {
                    subMap.put(rword, subMap.getOrDefault(rword, 0) + 1);
                    count++;
                    while (l <= r && subMap.get(rword) > wordsMap.getOrDefault(rword, 0)) {
                        String lword = s.substring(l, l + oneLen);
                        subMap.put(lword, subMap.getOrDefault(lword, 0) - 1);
                        count--;
                        l += oneLen;
                    }
                    if (count == words.length) {
                        res.add(l);
                    }
                }
            }
        }
        return res;
    }
}