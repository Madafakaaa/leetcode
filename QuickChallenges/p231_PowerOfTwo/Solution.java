package QuickChallenges.p231_PowerOfTwo;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/19 1:29
 */
class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        long x = n;
        return (x & (x - 1)) == 0;
    }
}
