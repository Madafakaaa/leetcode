package IsomorphicStrings;

import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map1 = new HashMap<>();
        ArrayList<Integer> pattern1 = new ArrayList<Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (!map1.containsKey(s.charAt(i))) {
                map1.put(s.charAt(i), i);
            }
            pattern1.add(map1.get(s.charAt(i)));
        }
        HashMap<Character, Integer> map2 = new HashMap<>();
        ArrayList<Integer> pattern2 = new ArrayList<Integer>();
        for (int i = 0; i < t.length(); i++) {
            if (!map2.containsKey(t.charAt(i))) {
                map2.put(t.charAt(i), i);
            }
            pattern2.add(map2.get(t.charAt(i)));
        }
        if (pattern1.equals(pattern2)) {
            return true;
        }
        return false;
    }
}
