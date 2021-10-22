package p243_ShortestWordDistance;

import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/10/20 15:42
 */
class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) {
                set1.add(i);
                continue;
            }
            if (wordsDict[i].equals(word2)) {
                set2.add(i);
            }
        }
        int res = wordsDict.length;
        for (Integer i1 : set1) {
            for (Integer i2 : set2) {
                res = Math.min(res, Math.abs(i1 - i2));
            }
        }
        return res;
    }
}
