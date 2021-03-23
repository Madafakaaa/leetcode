package JewelsAndStones;

import java.util.HashSet;

class Solution {

    public int numJewelsInStones(String J, String S) {
        if (J.length() == 0 || S.length() == 0) {
            return 0;
        }
        int result = 0;
        HashSet<Character> jewels = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            jewels.add(J.charAt(i));
        }
        for (int i = 0; i < S.length(); i++) {
            if (jewels.contains(S.charAt(i))) {
                result++;
            }
        }
        return result;
    }

}