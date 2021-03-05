package p003_LongestSubstringWithoutRepeatingCharacter;

import java.util.HashMap;

class Solution {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 1) {
            return 1;
        }
        int maxLength = 0;
        int lower = 0;
        HashMap<Integer, Character> map = new HashMap<Integer, Character>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsValue(s.charAt(i))) {
                // Calculate substring length
                maxLength = maxLength > (i - lower) ? maxLength : (i - lower);
                // Remove all the Character to the duplicate Character
                while (map.containsValue(s.charAt(i))) {
                    map.remove(lower);
                    lower++;
                }
            }
            map.put(i, s.charAt(i));
        }
        maxLength = maxLength > (s.length() - lower) ? maxLength : (s.length() - lower);
        return maxLength;
    }

}