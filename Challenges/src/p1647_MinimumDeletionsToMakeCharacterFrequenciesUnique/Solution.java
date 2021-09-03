package p1647_MinimumDeletionsToMakeCharacterFrequenciesUnique;

import java.util.HashSet;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/2 23:10
 */
class Solution {
    public int minDeletions(String s) {
        if (s.length() <= 1) {
            return 0;
        }
        int[] frequencies = new int[26];
        int res = 0;
        HashSet<Integer> frequencySet = new HashSet<>();
        for (char c : s.toCharArray()) {
            frequencies[c - 'a']++;
        }
        for (int frequency : frequencies) {
            if (frequency != 0) {
                while (frequency > 0 && frequencySet.contains(frequency)) {
                    frequency--;
                    res++;
                }
                frequencySet.add(frequency);
            }
        }
        return res;
    }
}
