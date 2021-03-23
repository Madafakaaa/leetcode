package UniqueWordAbbreviation;

import java.util.HashMap;
import java.util.HashSet;

class ValidWordAbbr {

    HashMap<String, Integer> map;
    HashSet<String> words;

    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<>();
        words = new HashSet<>();
        for (int i = 0; i < dictionary.length; i++) {
            if (!words.contains(dictionary[i])) {
                map.put(getAbbr(dictionary[i]), map.getOrDefault(getAbbr(dictionary[i]), 0) + 1);
                words.add(dictionary[i]);
            }
        }
    }

    public String getAbbr(String str) {
        StringBuffer abbr = new StringBuffer();
        abbr.append(str.charAt(0));
        abbr.append(str.length());
        abbr.append(str.charAt(str.length() - 1));
        return abbr.toString();
    }

    public boolean isUnique(String word) {
        if (map.containsKey(getAbbr(word))) {
            if (map.get(getAbbr(word)) == 1 && words.contains(word)) {
                return true;
            }
            return false;
        }
        return true;
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */