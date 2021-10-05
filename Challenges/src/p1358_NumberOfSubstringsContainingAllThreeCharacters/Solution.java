package p1358_NumberOfSubstringsContainingAllThreeCharacters;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/30 0:18
 */
class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int l = 0, r = 0, ans = 0;
        char[] str = s.toCharArray();
        int[] c = new int[3];
        while (r < n) {
            c[str[r] - 'a']++;
            while (l <= r && c[0] * c[1] * c[2] != 0) {
                ans += n - r;
                c[str[l++] - 'a']--;
            }
            r++;
        }
        return ans;
    }
}
