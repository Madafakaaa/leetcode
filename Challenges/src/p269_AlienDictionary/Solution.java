package p269_AlienDictionary;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/6 1:17
 */
class Solution {

    public String alienOrder(String[] words) {
        // find elements
        int[] inDegree = new int[26];
        int count = 0;
        Arrays.fill(inDegree, -1);
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (inDegree[c - 'a'] != 0) {
                    inDegree[c - 'a'] = 0;
                    count++;
                }
            }
        }
        boolean[][] adjacency = new boolean[26][26];
        // find edges
        outLoop:
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    if (adjacency[word2.charAt(j) - 'a'][word1.charAt(j) - 'a']) {
                        return "";
                    }
                    if (!adjacency[word1.charAt(j) - 'a'][word2.charAt(j) - 'a']) {
                        adjacency[word1.charAt(j) - 'a'][word2.charAt(j) - 'a'] = true;
                        inDegree[word2.charAt(j) - 'a']++;
                    }
                    continue outLoop;
                }
            }
            if (word1.length() > word2.length()) {
                return "";
            }
        }
        boolean remain = true;
        StringBuilder sb = new StringBuilder();
        Set<Character> set = new HashSet<>();
        while (remain) {
            remain = false;
            for (int i = 0; i < 26; i++) {
                if (inDegree[i] == 0) {
                    set.add((char) (i + 'a'));
                    inDegree[i] = -1;
                }
            }
            for (char c : set) {
                sb.append(c);
                for (int i = 0; i < 26; i++) {
                    if (adjacency[c - 'a'][i]) {
                        inDegree[i]--;
                    }
                }
            }
            set.clear();
            for (int i = 0; i < 26; i++) {
                if (inDegree[i] == 0) {
                    remain = true;
                    continue;
                }
            }
        }
        if (sb.length() != count) {
            return "";
        }
        return sb.toString();
    }
}



























