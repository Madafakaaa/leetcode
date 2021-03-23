package ReverseWordsInAStringIII;

import java.util.Arrays;
import java.util.List;

class Solution {
    public String reverseWords(String s) {
        // remove leading spaces
        s = s.trim();
        // split by multiple spaces
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        for (int i = 0; i < wordList.size(); i++) {
            StringBuilder sb = new StringBuilder(wordList.get(i));
            sb.reverse();
            wordList.set(i, sb.toString());

        }
        return String.join(" ", wordList);
    }
}