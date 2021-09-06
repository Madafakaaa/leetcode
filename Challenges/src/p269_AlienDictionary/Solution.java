package p269_AlienDictionary;

import java.util.*;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/6 1:17
 */
class Solution {


    public String alienOrder(String[] words) {
        // Find all characters
        HashMap<Character, Set<Character>> smallerAdjs = new HashMap<>(26);
        int[] counts = new int[26];
        Arrays.fill(counts, -1);
        for (String word : words) {
            for (Character c : word.toCharArray()) {
                if (counts[c - 'a'] == -1) {
                    counts[c - 'a'] = 0;
                    smallerAdjs.put(c, new HashSet<>(25));
                }
            }
        }
        // Find all edges
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            // Check that word2 is not a prefix of word1.
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    if (!smallerAdjs.get(word1.charAt(j)).contains(word2.charAt(j))) {
                        // increase inDegree
                        counts[word2.charAt(j) - 'a']++;
                        // add new smaller adj
                        smallerAdjs.get(word1.charAt(j)).add(word2.charAt(j));
                    }
                    break;
                }
            }
        }
        // Topological sort
        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        boolean hasNewChar = true;
        while (hasNewChar) {
            hasNewChar = false;
            for (int i = 0; i < counts.length; i++) {
                if (counts[i] == 0) {
                    counts[i] = -1;
                    queue.add((char) ('a' + i));
                    sb.append((char) ('a' + i));
                    hasNewChar = true;
                }
            }
            while (!queue.isEmpty()) {
                Character temp = queue.poll();
                Set<Character> smallerChars = smallerAdjs.get(temp);
                for (char smallerChar : smallerChars) {
                    counts[smallerChar - 'a']--;
                }
            }
        }
        String res = sb.toString();
        if (sb.length() < smallerAdjs.size()) {
            return "";
        }
        return res;
    }

}
