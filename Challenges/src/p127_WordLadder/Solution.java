package p127_WordLadder;

import java.util.ArrayList;
import java.util.List;

/**
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
 * <p>
 * Every adjacent pair of words differs by a single letter.
 * Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
 * sk == endWord
 * Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
 * <p>
 * Example 1:
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * Output: 5
 * Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
 * <p>
 * Example 2:
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * Output: 0
 * Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 */
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.length() != endWord.length()) {
            return 0;
        }
        List<String> tempList = new ArrayList<>();
        tempList.add(beginWord);
        int res = 0;
        while (!tempList.isEmpty() && !wordList.isEmpty()) {
            res++;
            List<String> newList = new ArrayList<>();
            for (int i = 0; i < tempList.size(); i++) {
                for (int j = wordList.size() - 1; j >= 0; j--) {
                    if (checkAdjacent(tempList.get(i), wordList.get(j))) {
                        if (wordList.get(j).equals(endWord)) {
                            return res;
                        }
                        newList.add(wordList.get(j));
                        wordList.remove(j);
                    }
                }
            }
            tempList = newList;
        }
        return 0;
    }

    public boolean checkAdjacent(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int diff = 0;
        char[] char1 = word1.toCharArray();
        char[] char2 = word2.toCharArray();
        for (int i = 0; i < char1.length; i++) {
            if (char1[i] != char2[i]) {
                diff++;
            }
        }
        return diff == 1;
    }
}