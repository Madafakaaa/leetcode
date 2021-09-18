package p343_IntegerBreak;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/15 15:34
 */
class Solution {
    public int integerBreak(int n) {
        if (n < 4) {
            return n - 1;
        }
        int res = 1;
        while (n > 4) {
            res *= 3;
            n -= 3;
        }
        return res * n;
    }
}
