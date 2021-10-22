package p342_PowerOfFour;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/10/21 14:55
 */
class Solution {
    public boolean isPowerOfFour(int n) {
        if (n == 0) {
            return false;
        }
        while (n % 4 == 0) {
            n /= 4;
        }
        return n == 1;
    }
}
