package p409_LongestPalindrome;

import java.util.HashSet;
import java.util.Set;

class Solution {

    public int longestPalindrome(String s) {
        int res = 0;
        Set<Character> set = new HashSet<Character>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                res += 2;
                set.remove(c);
            } else {
                set.add(c);
            }
        }
        if (!set.isEmpty()) {
            res++;
        }
        return res;
    }

}