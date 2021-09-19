package p266_PalindromePermutation;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/19 1:18
 */
public class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] map = new int[128];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)]++;
            if (map[s.charAt(i)] % 2 == 0)
                count--;
            else
                count++;
        }
        return count <= 1;
    }
}
