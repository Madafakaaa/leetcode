package p003_LongestSubstringWithoutRepeatingCharacter;

class Solution {

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        int[] count = new int[256];
        int left = 0, res = 0;
        for (int i = 0; i < s.length(); i++) {
            while (count[s.charAt(i)] != 0) {
                count[s.charAt(left)]--;
                left++;
            }
            count[s.charAt(i)]++;
            res = Math.max(res, i - left + 1);
        }
        return res;
    }

}